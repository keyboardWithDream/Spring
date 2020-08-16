package com.study.spring.service.impl;

import com.study.spring.dao.IAccountDao;
import com.study.spring.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author Harlan
 * @date 2020/8/13 17:49
 * 账户的业务层实现类
 * 注解实现配置
 */
@Service("accountService")
@Scope(value = "singleton")
public class AccountServiceImpl implements IAccountService {

    @Resource(name = "accountDao")
    private IAccountDao dao;

    @Value(value = "test")
    private String name;

    @PostConstruct
    public void init(){
        System.out.println("初始化方法执行...");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("销毁方法执行...");
    }

    public void save() {
        dao.save();
        System.out.println(name);
    }

}
