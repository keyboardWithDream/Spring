package com.study.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Harlan
 * @date 2020-8-20 下午 3:17
 * 模拟消费者
 */
public class Client {

    public static void main(String[] args) {

        final Producer producer = new Producer();

        //动态代理
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(Producer.class.getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {

            /**
             * 执行被代理对象的任何方法都会经过该方法
             * @param proxy 代理对象的引用
             * @param method 当前执行的方法
             * @param args 当前执行方法所需要的参数
             * @return 和被代理对象方法有相同的返回值
             * @throws Throwable 异常
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //增强代码
                Object result = null;
                Double money = (Double)args[0];
                if ("saleProduct".equals(method.getName())){
                    result = method.invoke(producer, money*0.8);
                }
                return result;
            }
        });

        proxyProducer.saleProduct(10000d);
    }
}
