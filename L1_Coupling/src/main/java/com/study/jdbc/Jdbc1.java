package com.study.jdbc;

import java.sql.*;

/**
 * @author Harlan
 * @date 2020/8/13 16:58
 * 通过jdbc演示程序的耦合
 */
public class Jdbc1 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //1.注册驱动
        //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //解耦
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring?serverTimezone=UTC", "root", "Hhn004460");
        //3.获取操作数据库的预处理对象
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM account");
        //4.执行SQL, 得到结果集
        ResultSet rs = ps.executeQuery();
        //5.遍历结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
