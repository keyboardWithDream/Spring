package com.study.spring.service.impl;

import com.study.spring.service.IAccountService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

/**
 * @author Harlan
 * @date 2020-8-20 下午 6:57
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    public void save() {
        System.out.println("save方法执行...");
    }

    public void update(int id) {
        System.out.println("update方法执行..." + id);
    }

    public int delete() {
        System.out.println("delete方法执行...");
        return 0;
    }
}
