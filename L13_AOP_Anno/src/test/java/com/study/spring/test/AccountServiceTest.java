package com.study.spring.test;

import com.study.spring.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Harlan
 * @date 2020-8-20 下午 8:02
 */
public class AccountServiceTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService service = ac.getBean("accountService", IAccountService.class);
        service.save();
        service.update(1);
        service.delete();
    }
}
