package com.moli.usercenter.server.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @Autowired
    private ApplicationContext appContext;

    @Test
    public void UserTest() {
        System.out.println("=====: " + userService.select("1"));
    }

    @Test
    public void appContextTest(){
       List<UserService> aaa = new ArrayList<>();
       aaa.addAll(appContext.getBeansOfType(UserService.class).values());

        aaa.forEach(e->{
            e.select("1");
        });
    }

    @Test
    public void jdbcTest() {
        Connection con;
       // public Connection getConnection(){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("数据库驱动加载成功");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=UTF-8", "root", "123456");
                String sql = "insert into user (name) values(?)"; // 生成一条sql语句
                // 创建一个Statment对象
                PreparedStatement ps = con.prepareStatement(sql);
                // 为sql语句中第一个问号赋值
                ps.setString(1, "lisi");

                // 为sql语句中第二个问号赋值
               // ps.setString(2, "aaa");
                // 执行sql语句
                ps.executeUpdate();
                // 关闭数据库连接对象
                con.close();
                System.out.println("jjk插入完毕！！！");
                System.out.println("数据库连接成功");
            } catch (SQLException e) {
                e.printStackTrace();
            }

      //  }
    }

}
