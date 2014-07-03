package com.snow.annotation.demo;

import java.lang.annotation.*;

/**
 * Created by Administrator on 14-7-3.
 * 注意这里的@Target与@Description里的不同,参数成员也不同
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Name {
    public String originate();
    public String community();
}
