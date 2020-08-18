package com.study.spring.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Harlan
 * @date 2020/8/18 20:43
 * 连接的工具类，用于从数据库中获取一个连接，并且和事务绑定
 */
@Component
public class ConnectionUtils {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    @Resource(name = "ds")
    private DataSource ds;


    /**
     * 获取当前线程上的连接
     * @return 连接对象
     */
    public Connection getThreadConnection() {
        Connection conn = tl.get();

        try {
            if (conn == null) {
                conn = ds.getConnection();
                tl.set(conn);
            }
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 把连接对象和线程解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
