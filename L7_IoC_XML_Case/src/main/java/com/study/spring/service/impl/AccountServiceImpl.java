package com.study.spring.service.impl;

import com.study.spring.dao.IAccountDao;
import com.study.spring.domian.Account;
import com.study.spring.service.IAccountService;

import java.util.List;

/**
 * @author Harlan
 * @date 2020/8/16 18:16
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao dao;

    public void setDao(IAccountDao dao) {
        this.dao = dao;
    }

    public List<Account> findAll() {
        return dao.findAll();
    }

    public Account findById(Integer id) {
        return dao.findById(id);
    }

    public void save(Account account) {
        dao.save(account);
    }

    public void update(Account account) {
        dao.update(account);
    }

    public void delete(Integer id) {
        dao.delete(id);
    }
}
