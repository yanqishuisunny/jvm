package com.shengsiyuan.jvm.classloader;



public class MyTest18_1 {

    public static void main(String[] arg) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\xinyang\\Desktop\\");
        Class<?> clazz = loader1.loadClass("com.example.jvm.demo.jvm.MyTest2");
        System.out.println("class:" + clazz.hashCode());
        System.out.println("class loader" + clazz.getClassLoader());
    }

}
