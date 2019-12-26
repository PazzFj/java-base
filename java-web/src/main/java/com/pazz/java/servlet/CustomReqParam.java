package com.pazz.java.servlet;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomReqParam {

    /**
     * 表示参数的别名，必填
     */
    String value();

}
