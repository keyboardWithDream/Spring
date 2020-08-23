package com.study.spring.jdbctemplate;


import com.study.spring.dao.IAccountDao;
import com.study.spring.domian.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

/**
 * @author Harlan
 * @date 2020-8-22 下午 2:44
 */
public class JdbcTemplate1 {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);
        Account account = accountDao.findById(1);
        System.out.println(account);
        List<Account> accounts = accountDao.findByName("eee");
        System.out.println(accounts);
    }
}
