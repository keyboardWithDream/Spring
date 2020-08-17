package com.study.spring.test;


import com.study.spring.domian.Account;
import com.study.spring.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Harlan
 * @date 2020/8/16 23:17
 */
public class AccountServiceTest {

    @Test
    public void testFindAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService service = ac.getBean("accountService", IAccountService.class);
        List<Account> accounts = service.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindById(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService service = ac.getBean("accountService", IAccountService.class);
        Account account = service.findById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("Harlan");
        account.setMoney(999999.0);

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService service = ac.getBean("accountService", IAccountService.class);
        service.save(account);
    }

    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(4);
        account.setName("Test");
        account.setMoney(9999999999.0);

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService service = ac.getBean("accountService", IAccountService.class);
        service.update(account);
    }

    @Test
    public void testDelete(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountService service = ac.getBean("accountService", IAccountService.class);
        service.delete(4);
    }
}
