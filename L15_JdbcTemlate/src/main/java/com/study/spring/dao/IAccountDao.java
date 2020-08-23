package com.study.spring.dao;

import com.study.spring.domian.Account;

import java.util.List;

/**
 * @author Harlan
 * @date 2020-8-23 下午 1:49
 */
public interface IAccountDao {

    /**
     * 根据id查询账户
     * @param id id
     * @return 账户信息
     */
    Account findById(Integer id);

    /**
     * 根据名称查询
     * @param name 名称
     * @return 账户信息
     */
    List<Account> findByName(String name);

    /**
     * 更新账户
     * @param account 账户信息
     */
    void update(Account account);
}
