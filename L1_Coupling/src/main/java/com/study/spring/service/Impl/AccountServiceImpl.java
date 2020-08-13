package com.study.spring.service.Impl;

import com.study.spring.dao.IAccountDao;
import com.study.spring.dao.impl.AccountDaoImpl;
import com.study.spring.service.IAccountService;

/**
 * @author Harlan
 * @date 2020/8/13 17:49
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao dao = new AccountDaoImpl();

    public void save() {
        dao.save();
    }

}
