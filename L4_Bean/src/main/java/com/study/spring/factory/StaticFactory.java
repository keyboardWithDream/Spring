package com.study.spring.factory;

import com.study.spring.service.IAccountService;
import com.study.spring.service.impl.AccountServiceImpl;

/**
 * @author Harlan
 * @date 2020/8/14 20:29
 */
public class StaticFactory {

    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
