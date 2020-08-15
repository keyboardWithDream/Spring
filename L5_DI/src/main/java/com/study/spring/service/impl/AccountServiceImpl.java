package com.study.spring.service.impl;

import com.study.spring.service.IAccountService;

import java.util.Date;

/**
 * @author Harlan
 * @date 2020/8/13 17:49
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void save() {
        System.out.println("Service中Save方法执行了...\n" +
                "name : " + name +"\n" +
                "age : " + age +"\n" +
                "birthday : " + birthday);
    }

}
