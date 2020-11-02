package com.moli.usercenter.server.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Setter
@Getter
public class User {
    public static void main(String[] args) throws Exception {

        Long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        Long endTime = System.currentTimeMillis();

        System.out.println((endTime - startTime) / 1000);
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String dateStr = today.format(fmt);
        System.out.println(today);
        System.out.println(new Date());
        System.out.println(dateStr);
        String timeStr1 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
      //  String timeStr2 = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));

        System.out.println("当前时间为:" + timeStr1);
       // System.out.println("当前时间为:" + timeStr2);

//        byte[] b = {1};
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
//        InputStream input2 =swapStream;
//        FileInputStream input = (FileInputStream)input2;
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = today.atZone(zoneId);//Combines this date-time with a time-zone to create a  ZonedDateTime.
        Date date = Date.from(zdt.toInstant());
        System.out.println(date.toString());//Tue Mar 27 14:17:17 CST 2018

    }

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    @Column(name = "nick_name")
    private String nickName;

    private String password;

    private String avatar;

    private String phone;

    private String email;

    private Integer sex;

    private String salt;

    private Integer status;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;
}
