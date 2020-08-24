package com.dingzhen.redisUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Aspect
public class RedisQueryAspect {
    @Resource
    private RedisUtil redisUtil;
    @Pointcut("@annotation(com.dingzhen.redisUtils.RedisQueryAnnotation)")
    public void pointCut(){
    }
    @Around(value = "pointCut()")
    public Object queryAspect(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature signature= (MethodSignature) proceedingJoinPoint.getSignature();
        RedisQueryAnnotation parameterAnnotations = signature.getMethod().getAnnotation(RedisQueryAnnotation.class);
        if (redisUtil.hasKey(parameterAnnotations.redisKey())) {
            return redisUtil.hget(parameterAnnotations.redisKey(),parameterAnnotations.itemName());
        }
        Object o = proceedingJoinPoint.proceed();
        redisUtil.hset(parameterAnnotations.redisKey(), parameterAnnotations.itemName(), o);
        return o;
    }
}
