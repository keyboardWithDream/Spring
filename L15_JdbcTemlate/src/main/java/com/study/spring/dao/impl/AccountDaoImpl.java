package com.study.spring.dao.impl;

import com.study.spring.dao.IAccountDao;
import com.study.spring.domian.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author Harlan
 * @date 2020-8-23 下午 1:52
 */
public class AccountDaoImpl implements IAccountDao {

    private JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public Account findById(Integer id) {
        return template.queryForObject("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), id);
    }

    public List<Account> findByName(String name) {
        return template.query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), name);
    }

    public void update(Account account) {
        template.update("update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }
}
