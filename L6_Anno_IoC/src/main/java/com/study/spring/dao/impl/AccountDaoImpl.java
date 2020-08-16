package com.study.spring.dao.impl;

import com.study.spring.dao.IAccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author Harlan
 * @date 2020/8/13 17:52
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {

    public void save() {
        System.out.println("账户已被保存...");
    }
}
