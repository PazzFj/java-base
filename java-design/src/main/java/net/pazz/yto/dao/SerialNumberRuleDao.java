package net.pazz.yto.dao;

import net.pazz.yto.lock.SerialNumberRuleEntity;

public interface SerialNumberRuleDao {

    /**
     * 根据code查询序号实体并添加悲观锁
     */
    SerialNumberRuleEntity querySerialNumberRuleForUpdate(String code);

    /**
     * 新增序号信息
     */
    void addSerialNumberRule(SerialNumberRuleEntity serialNumberRuleEntity);

    /**
     * 更新序号信息
     */
    void updateSerialNumberRule(SerialNumberRuleEntity serialNumberRuleEntity);

}
