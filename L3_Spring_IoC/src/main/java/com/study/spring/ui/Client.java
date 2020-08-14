package com.study.spring.ui;

import com.study.spring.dao.IAccountDao;
import com.study.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext fileSystemXmlApplicationContext = new FileSystemXmlApplicationContext("E:\\Code\\Spring\\L3_Spring_IoC\\src\\main\\resources\\bean.xml");

        //2.根据id获取bean对象
        IAccountService service = fileSystemXmlApplicationContext.getBean("accountService", IAccountService.class);
        IAccountDao dao = applicationContext.getBean("accountDao", IAccountDao.class);

        System.out.println(service);
        System.out.println(dao);
    }
}
