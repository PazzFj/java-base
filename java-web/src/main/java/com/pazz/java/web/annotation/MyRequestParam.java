package com.pazz.java.web.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestParam {

    /**
     * 表示参数的别名，必填
     * @return
     */
    String value();

}
