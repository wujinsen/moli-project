package com.moli.usercenter.server.controller;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {

        /*
         * DecimalFormat比较灵活支持四舍五入
         * 最多保留几位小数，就用几个#，最少位就用0来确定
         * DecimalFormat df = new DecimalFormat("###")只要小数点整数3位
         */

        DecimalFormat df = new DecimalFormat("###.##");
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float) (792515+223201)/(float)( 792515+14216+223201+3439)*100);
        System.out.println(result+"%");



        Timestamp ts = new Timestamp(System.currentTimeMillis());
        Timestamp ts2 = new Timestamp(System.currentTimeMillis());
        String str = "2020-02-12 11:11:11";
        ts = Timestamp.valueOf(str);
        System.out.println(ts);
        System.out.println(ts2);
    }
}
