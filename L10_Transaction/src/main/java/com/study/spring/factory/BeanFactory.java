package com.study.spring.factory;

import com.study.spring.service.IAccountService;
import com.study.spring.utils.TransactionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Harlan
 * @date 2020-8-20 下午 4:03
 * 用于创建Service的代理对象的工厂
 */
@Component
public class BeanFactory {

    @Resource(name = "accountService")
    private IAccountService accountService;

    @Resource(name = "transactionManager")
    private TransactionManager tm;


    /**
     * 获取Service的代理对象
     * @return 代理对象
     */
    @Bean(name = "proxyAccountService")
    @Scope("prototype")
    public IAccountService getAccountService(){
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {

            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println("正在执行动态代理...");
                Object result = null;

                try{
                    tm.beginTransaction();
                    result = method.invoke(accountService, args);
                    tm.commit();
                }catch (Exception e){
                    tm.rollback();
                    e.printStackTrace();
                }finally {
                    tm.release();
                }
                return result;
            }
        });
    }
}
