package com.dingzhen.redisUtils;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented//说明该注解将被包含在javadoc中
//@Retention: 定义注解的保留策略,
@Retention(RUNTIME)// 注解会在class字节码文件中存在，在运行时可以通过反射获取到
//@Target：定义注解的作用目标
@Target(METHOD)// 方法和方法参数
@Inherited//说明子类可以继承父类中的该注解
public @interface RedisQueryAnnotation {
    String redisKey();
    String itemName();
}
