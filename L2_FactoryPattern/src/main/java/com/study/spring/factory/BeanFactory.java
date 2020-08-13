package com.study.spring.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
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

    /**
     * 定义一个Map用于存放我们要创建的对象, 既为容器
     */
    private static Map<String, Object> beans;


    static {
        //加载配置文件
        props = new Properties();
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //实例化容器
        beans = new HashMap<String, Object>();
        //取出配置文件中所有的Key
        Enumeration<Object> keys = props.keys();
        //遍历枚举
        while (keys.hasMoreElements()){
            //取出每个key
            String key = keys.nextElement().toString();
            //根据key获取value
            String beanPath = props.getProperty(key);
            //反射创建对象
            try {
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器
                beans.put(key, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 根据名称获取对象
     * @param beanName 名称
     * @return 对象
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }
}
