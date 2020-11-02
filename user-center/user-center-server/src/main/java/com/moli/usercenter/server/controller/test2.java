package com.moli.usercenter.server.controller;

import java.text.NumberFormat;

public class test2 {

    public static void main(String[] args) {
        int a=5;
        int b=10;
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);
        String result = numberFormat.format((float)a/(float)b*100);
        String result2 = numberFormat.format((float)a/(float)b*100);
        System.out.println("a和b的百分比为:" + result + "%");
        System.out.println(result2);
    }
}
