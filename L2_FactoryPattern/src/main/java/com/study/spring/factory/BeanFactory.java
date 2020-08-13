package com.study.spring.factory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * @author Harlan
 * @date 2020/8/13 18:02
 * 一个创建Bean对象的工厂
 * Bean 在计算机语言中, 有可重用组件的含义.
 * JavaBean 用Java语言编写的可重用组件.
 * 工厂用于创建service和dao对象
 *  需要配置文件
 *      唯一标识 = 全限定类名
 *  通过反射创建对象
 */
public class BeanFactory {

    private static Properties props;

    //加载配置文件
    static {
        props = new Properties();
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据名称获取对象
     * @param beanName 名称
     * @return 对象
     */
    public static Object getBean(String beanName){
        Object bean = null;
        String beanPath = props.getProperty(beanName);
        try {
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
