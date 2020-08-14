package com.study.spring.service.impl;

import com.study.spring.service.IAccountService;

/**
 * @author Harlan
 * @date 2020/8/13 17:49
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {


    public void save() {
        System.out.println("Service中Save方法执行了");
    }

}
