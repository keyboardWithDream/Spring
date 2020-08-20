package com.study.spring.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author Harlan
 * @date 2020-8-20 下午 6:59
 * 用于记录日志的工具类，提供了公共的代码
 */
public class Logger {

    /**
     * 用于打印日志：计划在切入点方法之前执行（切入点方法就是业务层方法）
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知");
    }

    /**
     * 后置通知
     */
    public void afterReturnPrintLog(){
        System.out.println("后置通知");
    }

    /**
     * 异常通知
     */
    public void throwingPrintLog(){
        System.out.println("异常通知");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("最终通知");
    }

    /**
     * 环绕通知
     * @return
     */
    public Object aroundPrintLog(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            Object[] args = joinPoint.getArgs();
            System.out.println("环绕通知");
            result = joinPoint.proceed(args);
            System.out.println("环绕通知");
            return result;
        } catch (Throwable throwable) {
            System.out.println("环绕通知");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("环绕通知");
        }
    }
}
