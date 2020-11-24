package com.shengsiyuan.jvm.gc;

/**
 * -XX:PretenureSizeThreshold=111111 当我们指定的这个值,如果新创建的对象他的大小
 * 超过了PretenureSizeThreshold这个预值，那么它创建的对象就不会在新生代生产，而会
 * 在老年代创建.它需要搭配 Serial收集器一起使用
 */
public class MyTest2 {
    public static void main(String[] arg) {
        int size = 1024 * 1024;
        byte[] myAlloc1 = new byte[8 * size];
        System.out.println("hello world");
    }
}
