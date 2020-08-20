package com.study.spring.utils;

/**
 * @author Harlan
 * @date 2020-8-20 下午 6:59
 * 用于记录日志的工具类，提供了公共的代码
 */
public class Logger {

    /**
     * 用于打印日志：计划在切入点方法之前执行（切入点方法就是业务层方法）
     */
    public void printLog(){
        System.out.println("Logger开始记录日志...");
    }
}
