package com.study.spring.ui;

import com.study.spring.service.IAccountService;
import com.study.spring.service.impl.AccountServiceImpl;

/**
 * @author Harlan
 * @date 2020/8/13 17:54
 * 模拟表现层, 用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
        IAccountService service = new AccountServiceImpl();
        service.save();
    }
}
