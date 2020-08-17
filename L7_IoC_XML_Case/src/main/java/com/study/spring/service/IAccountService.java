package com.study.spring.service;

import com.study.spring.domian.Account;

import java.util.List;

/**
 * @author Harlan
 * @date 2020/8/16 18:10
 * 账户业务层接口
 */
public interface IAccountService {

    /**
     * 查询所有账户
     * @return 账户列表
     */
    List<Account> findAll();

    /**
     * 查询账户
     * @param id 账户id
     * @return 账户信息
     */
    Account findById(Integer id);

    /**
     * 保存账户
     * @param account 账户信息
     */
    void save(Account account);

    /**
     * 更新账户
     * @param account 账户信息
     */
    void update(Account account);

    /**
     * 删除账户
     * @param id 账户id
     */
    void delete(Integer id);
}
