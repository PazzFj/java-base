package com.pazz.java.servlet;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyTestController {

    /**
     * 表示给controller注册别名
     */
    String value() default "";

}
