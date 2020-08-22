package com.study.spring.jdbctemplate;


import com.study.spring.domian.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Harlan
 * @date 2020-8-22 下午 2:44
 */
public class JdbcTemplate1 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate template = ac.getBean("template", JdbcTemplate.class);

        template.update("insert into account(name, money) values (?, ?)", "eee", 20000);

        template.update("update account set name=?, money=? where id=?", "fff", 0, 5);

        template.update("delete from account where id=?", 6);

        List<Account> accounts = template.query("select * from account where money>?", new BeanPropertyRowMapper<Account>(Account.class), 1000);
        for (Account account : accounts) {
            System.out.println(account);
        }

        System.out.println("------------------------------------------");

        Account account = template.queryForObject("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), 1);
        System.out.println(account);
    }
}
