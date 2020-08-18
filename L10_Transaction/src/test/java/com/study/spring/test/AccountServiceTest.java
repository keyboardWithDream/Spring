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
    public void testTransfer(){
        service.transfer("aaa", "bbb", 100.0);
    }
}
