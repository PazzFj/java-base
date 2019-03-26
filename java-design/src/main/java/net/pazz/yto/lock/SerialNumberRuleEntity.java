package net.pazz.yto.lock;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author: Peng Jian
 * @date: 2018/6/15 17:42
 * @description:
 */
@Data
public class SerialNumberRuleEntity {

    /**编码*/
    private String code;
    /**名称*/
    private String name;
    /**当前日期*/
    private Date currentTime;
    /**当前值*/
    private Long currentNum;

    @Id
    private String id;
    //创建时间
    private Date createTime;
    //创建人
    private String createUser;
    //修改时间
    private Date modifyTime;
    //修改人
    private String modifyUser;

    @Override
    public String toString() {
        return "SerialNumberRuleEntity{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", currentTime=" + currentTime +
                ", currentNum=" + currentNum +
                ", id='" + id + '\'' +
                ", createTime=" + createTime +
                ", createUser='" + createUser + '\'' +
                ", modifyTime=" + modifyTime +
                ", modifyUser='" + modifyUser + '\'' +
                '}';
    }
}
