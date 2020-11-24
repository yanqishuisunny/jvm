package com.shengsiyuan.jvm.classloader;


public class MyTest22 {

    static{
        System.out.println("MyTest22 initializer");
    }

    public static void main(String[] arg) throws Exception {
        System.out.println(MyTest22.class.getClassLoader());

        System.out.println(MyTest2.class.getClassLoader());
    }

}
