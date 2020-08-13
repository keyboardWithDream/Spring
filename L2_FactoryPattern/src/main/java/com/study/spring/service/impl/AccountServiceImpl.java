package com.study.spring.service.impl;

import com.study.spring.dao.IAccountDao;
import com.study.spring.factory.BeanFactory;
import com.study.spring.service.IAccountService;

/**
 * @author Harlan
 * @date 2020/8/13 17:49
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao dao = (IAccountDao) BeanFactory.getBean("accountDao");

    public void save() {
        dao.save();
    }

}
