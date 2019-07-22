package net.pazz.yto.lock;

/**
 * @author: Peng Jian
 * @date: 2018/6/15 9:47
 * @description:
 */
public interface ISerialNumberService {

    /**
     * 生成序列号
     * @param serialNumberRule 序列号规则
     * @param params 参数
     * @return
     */
    String generateSerialNumber(SerialNumberRuleEnum serialNumberRule, String... params);

}
