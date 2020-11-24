package com.shengsiyuan.jvm.g1;

/**
 * -verbose:gc
 * -Xms10M
 * -Xmx10M
 * -XX:+UseG1GC
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -XX:MaxGCPauseMillis=200m
 *
 */

/**
 *
 * 1:java中全局变量或者静态变量可以被初始化几次
 * 2:java中的泛型是怎么实现的
 *
 */
public class MyTest1 {
    public static void main(String[] arg) {
        int size = 1024 * 1024;
        byte[] myAlloc1 = new byte[size];
        byte[] myAlloc2 = new byte[size];
        byte[] myAlloc3 = new byte[size];
        byte[] myAlloc4 = new byte[size];
        System.out.println("hello world");
    }
}
