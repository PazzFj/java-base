package com.pazz.java.core.lambda;

/**
 * @author: 彭坚
 * @create: 2018/12/12 16:57
 * @description:
 */
public class LambdaEntity {

    private String name;
    private String code;

    public LambdaEntity() {
    }

    public LambdaEntity(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "LambdaEntity{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
