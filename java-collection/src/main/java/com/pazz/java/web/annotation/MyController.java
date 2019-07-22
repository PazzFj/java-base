package com.pazz.java.web.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyController {

    /**
     * 表示给controller注册别名
     * @return
     */
    String value() default "";

}
