package com.study.proxy;

/**
 * @author Harlan
 * @date 2020-8-20 下午 3:05\
 * 对生产厂家要求的接口
 */
public interface IProducer {

    /**
     * 销售
     * @param money
     */
    public void saleProduct(Double money);

    /**
     * 售后
     * @param money
     */
    public void afterService(Double money);

}
