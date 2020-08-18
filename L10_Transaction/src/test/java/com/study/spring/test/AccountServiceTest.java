package com.study.spring.test;
import com.study.spring.domian.Account;
import com.study.spring.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Harlan
 * @date 2020/8/16 23:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    IAccountService service;

    @Test
    public void testFindAll(){
        List<Account> accounts = service.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindById(){
        Account account = service.findById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        Account account = new Account();
        account.setName("Harlan");
        account.setMoney(999999.0);

        service.save(account);
    }

    @Test
    public void testUpdate(){
        Account account = new Account();
        account.setId(5);
        account.setName("Test");
        account.setMoney(9999999999.0);

        service.update(account);
    }

    @Test
    public void testDelete(){
        service.delete(5);
    }

    @Test
    public void testTransfer(){
        service.transfer("aac", "bbb", 100.0);
    }
}
