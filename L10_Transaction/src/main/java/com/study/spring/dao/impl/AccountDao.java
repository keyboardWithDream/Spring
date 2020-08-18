package com.study.spring.dao.impl;

import com.study.spring.dao.IAccountDao;
import com.study.spring.domian.Account;
import com.study.spring.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Harlan
 * @date 2020/8/16 18:24
 */
@Repository("accountDao")
public class AccountDao implements IAccountDao {

    @Resource(name = "runner")
    private QueryRunner runner;

    @Resource(name = "connectionUtils")
    private ConnectionUtils connectionUtils;

    public List<Account> findAll() {
        try {
            return runner.query(connectionUtils.getThreadConnection(), "SELECT * FROM account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findById(Integer id) {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"SELECT * FROM account WHERE id = ?", new BeanHandler<Account>(Account.class), id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"INSERT INTO account(name, money) VALUES (?, ?)", account.getName(), account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"UPDATE account SET name=?, money=? WHERE id=?", account.getName(), account.getMoney(), account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Integer id) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"DELETE FROM account WHERE id=?", id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findByName(String name) {
        List<Account> result = null;
        try {
            result = runner.query(connectionUtils.getThreadConnection(),"SELECT * FROM account WHERE name = ?", new BeanListHandler<Account>(Account.class), name);
            if (result == null || result.size() == 0){
                throw new RuntimeException("结果集不存在!");
            }else if (result.size() > 1){
                throw new RuntimeException("有多个结果集！");
            }else {
                return result.get(0);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
