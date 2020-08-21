package com.study.spring.test;
import com.study.spring.domian.Account;
import com.study.spring.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Harlan
 * @date 2020/8/16 23:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {


    @Autowired
    IAccountService service;


    @Test
    public void testTransfer(){
        service.transfer("bbb", "aaa", 100.0);
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = service.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }
}
