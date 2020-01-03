package com.pazz.java.define;

/**
 * @author: Peng Jian
 * @create: 2020/1/3 14:07
 * @description:
 */
public enum TestTypeEnum {
    BMW_TYPE("BMW_TYPE", "宝马"),
    AUDI_TYPE("AUDI_TYPE", "奥迪"),
    BENZ_TYPE("BENZ_TYPE", "奔驰");

    private String code;
    private String name;

    TestTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static TestTypeEnum getByName(String name) {
        for (TestTypeEnum value : TestTypeEnum.values()) {
            if (value.getName().equals(name)) {
                return value;
            }
        }
        return null;
    }

    public static TestTypeEnum getByCode(String code) {
        for (TestTypeEnum value : TestTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
