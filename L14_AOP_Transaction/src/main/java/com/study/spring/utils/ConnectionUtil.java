package com.study.spring.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author Harlan
 * @date 2020-8-21 下午 5:27
 */
public class ConnectionUtil {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource ds;


    public void setDs(DataSource ds) {
        this.ds = ds;
    }

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
