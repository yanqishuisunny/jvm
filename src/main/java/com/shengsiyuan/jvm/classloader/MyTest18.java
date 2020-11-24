package com.shengsiyuan.jvm.classloader;

public class MyTest18 {

    public static void main(String[] arg) throws Exception {
//        MyTest16 loader1 = new MyTest16("loader1");
//        Class<?> clazz = loader1.loadClass("com.example.jvm.demo.jvm.MyTest2");
//        System.out.println("class:" + clazz.hashCode());
//        System.out.println("class loader:" + clazz.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

    }

}
