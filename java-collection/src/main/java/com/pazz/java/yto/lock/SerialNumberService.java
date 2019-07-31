package com.pazz.java.yto.lock;

import com.pazz.java.util.Argument;
import com.pazz.java.util.DateUtil;
import lombok.extern.apachecommons.CommonsLog;
import com.pazz.java.yto.dao.SerialNumberRuleDao;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.locks.Lock;

/**
 * @author: Peng Jian
 * @date: 2018/6/15 9:48
 * @description: 生成单号service
 */
//@Service
@CommonsLog
public class SerialNumberService implements ISerialNumberService {

    /**
     * Redis 锁前缀
     */
    private static final String LOCK_KEY_PREFIX = "serial_number:";

    private static final String DATE_TIME_MONTH = "yyyyMM";

    @Autowired
    private RedisLockRegistry redisLockRegistry;

    @Autowired
    private SerialNumberRuleDao serialNumberDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String generateSerialNumber(SerialNumberRuleEnum serialNumberRule, String... params) {
        Argument.notNull(serialNumberRule, "序号规则不能为空!");
        log.info("获取Redis分布式锁：" + serialNumberRule.getCode());
        String lockKey = LOCK_KEY_PREFIX + serialNumberRule.getCode();
        Lock lock = redisLockRegistry.obtain(lockKey);
        try {
            log.info("Redis分布式锁加锁:" + lockKey);
            lock.lock();
            log.info("Redis分布式锁加锁成功:" + lockKey);
            SerialNumberRuleEntity serialNumberRuleEntity = getSerialNumberRule(serialNumberRule);
            SerialNumberEntry result = spliceSerialNumber(serialNumberRule, serialNumberRuleEntity, true, params);
            serialNumberRuleEntity.setCurrentTime(Calendar.getInstance().getTime());
            serialNumberRuleEntity.setCurrentNum(result.getNextSequenceValue());
            serialNumberDao.updateSerialNumberRule(serialNumberRuleEntity);
            return result.getSerialNumber();
        } finally {
            log.info("Redis分布式锁释放锁:" + lockKey);
            lock.unlock();
            log.info("Redis分布式锁释放锁成功:" + lockKey);
        }
    }

    private SerialNumberRuleEntity getSerialNumberRule(SerialNumberRuleEnum serialNumberEnum) {
        // 根据业务类型查询序号并添加悲观锁
        SerialNumberRuleEntity serialNumberEntity = serialNumberDao.querySerialNumberRuleForUpdate(serialNumberEnum.getCode());

        if (serialNumberEntity == null) {
            // 业务类型序号不存在则添加序号信息
            serialNumberEntity = new SerialNumberRuleEntity();
            serialNumberEntity.setId(serialNumberEnum.getCode());
            serialNumberEntity.setCode(serialNumberEnum.getCode());
            serialNumberEntity.setName(serialNumberEnum.getName());
            serialNumberEntity.setCurrentNum(0L);
            serialNumberEntity.setCurrentTime(new Date());
            serialNumberDao.addSerialNumberRule(serialNumberEntity);
            // 新增序号后添加悲观锁
            serialNumberEntity = serialNumberDao.querySerialNumberRuleForUpdate(serialNumberEnum.getCode());
        }

        return serialNumberEntity;
    }

    /**
     * 根据序列Enum 序列Entity 生成 序列Entry
     *
     * @param serialNumberEnum   序号规则
     * @param serialNumberEntity 序号实体
     * @param params             参数
     * @return
     */
    private SerialNumberEntry spliceSerialNumber(SerialNumberRuleEnum serialNumberEnum, SerialNumberRuleEntity serialNumberEntity,
                                                 boolean formal, String[] params) {
        StringBuffer buffer = new StringBuffer(); //字符串拼接
        long seq = 0;   //序列值
        boolean resetNo = false; //是否重置
        if (serialNumberEnum.isNeedParams()) {
            // todo 需要拼接参数待实现
        }

        // 是否需要时间
        if (serialNumberEnum.isNeedTime() && serialNumberEnum.getTimeFormat().equals(DATE_TIME_MONTH)) {
            // 如果对于上一个已生成的编号已跨月，需重置对应的sequence
            String currentDate = DateUtil.convert(serialNumberEntity.getCurrentTime(), DateUtil.DATE_MONTH_FORMAT);
            String nowDate = DateUtil.convert(Calendar.getInstance().getTime(), DateUtil.DATE_MONTH_FORMAT);
            Long differDayNum = DateUtil.getTimeDiff(currentDate, nowDate);
            if (differDayNum > 0) {
                resetNo = true;
            }

        } else if (serialNumberEnum.isNeedTime()) {
            // 如果对于上一个已生成的编号已跨天，需重置对应的sequence
            String currentDate = DateUtil.convert(serialNumberEntity.getCurrentTime(), DateUtil.DATE_FORMAT);
            String nowDate = DateUtil.convert(Calendar.getInstance().getTime(), DateUtil.DATE_FORMAT);
            Long differDayNum = DateUtil.getTimeDiff(currentDate, nowDate);
            if (differDayNum > 0) {
                resetNo = true;
            }

        }
        // 字母前缀
        if (serialNumberEnum.isNeedLetterPrefix()) {
            buffer.append(serialNumberEnum.getLetterPrefix());
        }
        // 时间前缀
        if (serialNumberEnum.isNeedTime()) {
            buffer.append(serialNumberEnum.getTimeFormat());
        }
        // 分隔符
        if (serialNumberEnum.isNeedDelimiter()) {
            buffer.append(serialNumberEnum.getDelimiter());
        }
        // 数字项
        if (serialNumberEnum.isNeedNumber()) {
            // 针对日期+数字情况，如果跨天，则重置为1
            if (resetNo) {
                seq = 1;
            } else {
                seq = serialNumberEntity.getCurrentNum() + 1;
            }
            // 数字项是否固定位数
            if (serialNumberEnum.isFixedNumLen()) {
                buffer.append(String.format("%0" + serialNumberEnum.getNumLen() + "d", seq));
            } else {
                buffer.append(String.valueOf(seq));
            }
        }
        // 后缀
        if (serialNumberEnum.isNeedLetterSuffix()) {
            buffer.append(serialNumberEnum.getLetterSuffix());
        }

        return new SerialNumberEntry(buffer.toString(), Long.valueOf(seq));
    }

    /**
     * 序列Entry
     */
    private class SerialNumberEntry {
        /**
         * 生成的序号
         */
        private String serialNumber;
        /**
         * 下一个序列值
         */
        private Long nextSequenceValue;

        public SerialNumberEntry(String serialNumber, long nextSequenceValue) {
            this.serialNumber = serialNumber;
            this.nextSequenceValue = nextSequenceValue;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public long getNextSequenceValue() {
            return nextSequenceValue;
        }

        public void setNextSequenceValue(long nextSequenceValue) {
            this.nextSequenceValue = nextSequenceValue;
        }
    }

    public static void main(String[] args) {
        String str = String.format("%0" + 10 + "d", 2);
        System.out.println(str);

        notNull(String.class, "Type to check against must not be null");
        if (!String.class.isInstance(null)) {
            System.out.println("aaaaaaaaaaaaaaaaaa");
        }
    }
        public static void notNull(Object object, String message) {
            if (object == null) {
                throw new IllegalArgumentException(message);
            }
        }


}
