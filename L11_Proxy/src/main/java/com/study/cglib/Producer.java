package com.study.cglib;

import com.study.proxy.IProducer;

/**
 * @author Harlan
 * @date 2020-8-20 下午 3:02
 * 生产者
 */
public class Producer {

    /**
     * 销售
     * @param money
     */
    public void saleProduct(Double money){
        System.out.println("销售产品,并拿到钱: " + money);
    }

    /**
     * 售后
     * @param money
     */
    public void afterService(Double money){
        System.out.println("提供售后服务,并拿到钱: " + money);
    }
}
