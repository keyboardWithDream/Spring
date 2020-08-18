package com.study.spring.service.impl;

import com.study.spring.dao.IAccountDao;
import com.study.spring.domian.Account;
import com.study.spring.service.IAccountService;
import com.study.spring.utils.TransactionManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Harlan
 * @date 2020/8/16 18:16
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Resource(name = "accountDao")
    private IAccountDao dao;

    @Resource(name = "transactionManager")
    private TransactionManager tm;

    public List<Account> findAll() {
        try{
            tm.beginTransaction();
            List<Account> accounts = dao.findAll();
            tm.commit();
            return accounts;
        }catch (Exception e){
            tm.rollback();
            throw new RuntimeException(e);
        }finally {
            tm.release();
        }
    }

    public Account findById(Integer id) {

        try{
            tm.beginTransaction();
            Account account = dao.findById(id);
            tm.commit();
            return account;
        }catch (Exception e){
            tm.rollback();
            throw new RuntimeException(e);
        }finally {
            tm.release();
        }
    }

    public void save(Account account) {
        try{
            tm.beginTransaction();
            dao.save(account);
            tm.commit();
        }catch (Exception e){
            tm.rollback();
            e.printStackTrace();
        }finally {
            tm.release();
        }
    }

    public void update(Account account) {
        try{
            tm.beginTransaction();
            dao.update(account);
            tm.commit();
        }catch (Exception e){
            tm.rollback();
            e.printStackTrace();
        }finally {
            tm.release();
        }
    }

    public void delete(Integer id) {
        try{
            tm.beginTransaction();
            dao.delete(id);
            tm.commit();
        }catch (Exception e){
            tm.rollback();
            e.printStackTrace();
        }finally {
            tm.release();
        }
    }

    public void transfer(String fromName, String toName, Double money) {
        try{
            tm.beginTransaction();

            Account source = dao.findByName(fromName);
            source.setMoney(source.getMoney() - money);
            dao.update(source);

            int test = 1 / 0;

            Account target = dao.findByName(toName);
            target.setMoney(target.getMoney() + money);
            dao.update(target);

            tm.commit();
        }catch (Exception e){
            tm.rollback();
            e.printStackTrace();
        }finally {
            tm.release();
        }
    }
}
