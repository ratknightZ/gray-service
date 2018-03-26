package com.arms.service.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jinxuan
 * @since 2017/12/18
 * 权限拦截注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Sniff {

    /**
     * 此处填写权限名，只要符合其中一项权限名变通过验证
     * @return
     */
    String value();

}
