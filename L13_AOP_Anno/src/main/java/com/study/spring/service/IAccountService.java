package com.study.spring.service;

/**
 * @author Harlan
 * @date 2020-8-20 下午 6:53
 * 账户业务层接口
 */
public interface IAccountService {

    /**
     * 模拟账户保存
     * 无参无返回值
     */
    void save();

    /**
     * 模拟账户更新
     * 有参无返回值
     * @param id id
     */
    void update(int id);

    /**
     * 模拟删除账户
     * 无参有返回值
     * @return
     */
    int delete();
}
