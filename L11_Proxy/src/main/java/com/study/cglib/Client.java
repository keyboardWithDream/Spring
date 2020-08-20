package com.study.cglib;

import com.study.proxy.IProducer;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

/**
 * @author Harlan
 * @date 2020-8-20 下午 3:17
 * 模拟消费者
 */
public class Client {

    public static void main(String[] args) {

        final Producer producer = new Producer();

        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {

            /**
             * 执行被代理对象的方法都会经过该方法
             * @param o 被代理对象的引用
             * @param method 当前执行的方法
             * @param objects 当前执行方法的参数
             * @param methodProxy 当前执行方法的代理对象
             * @return 和被代理对象返回值相同
             * @throws Throwable 异常
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;

                Double money = (Double) objects[0];
                if ("saleProduct".equals(method.getName())){
                    result = method.invoke(producer, money*0.8);
                }
                return result;
            }
        });

        cglibProducer.saleProduct(10000d);
    }
}
