package com.study.spring.service.impl;

import com.study.spring.service.IAccountService;

import java.util.Date;

/**
 * @author Harlan
 * @date 2020/8/13 17:49
 * 账户的业务层实现类
 */
public class AccountServiceImpl2 implements IAccountService {

    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void save() {
        System.out.println("Service中Save方法执行了...\n" +
                "name : " + name +"\n" +
                "age : " + age +"\n" +
                "birthday : " + birthday);
    }

}
