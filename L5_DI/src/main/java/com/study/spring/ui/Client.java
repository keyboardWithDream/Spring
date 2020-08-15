package com.study.spring.ui;

import com.study.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harlan
 * @date 2020/8/13 17:54
 * 模拟表现层, 用于调用业务层
 */
public class Client {

    /**
     * 获取Spring的IoC核心容器, 并更具id获取对象
     * @param args .
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2.根据id获取bean对象
        IAccountService service = ac.getBean("accountService", IAccountService.class);

        service.save();
    }
}
