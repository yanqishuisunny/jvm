package com.shengsiyuan.jvm.classloader;

import com.sun.crypto.provider.AESKeyGenerator;

import java.lang.reflect.Method;

public class MyTest20 {

    public static void main(String[] arg) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");
        Class<?> clazz1 = loader1.loadClass("com.example.jvm.demo.jvm.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.example.jvm.demo.jvm.MyPerson");
        System.out.println(clazz1 == clazz2);
        /**
         * 结果为true，是因为第一个clazz1是由系统类加载器加载的，当clazz2加载的时候，因为MyPerson已经加载了，系统类加载器
         * 会直接把加载过的MyPerson赋值给clazz2
         */
        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();
        Method method = clazz1.getMethod("setMyPerson", Object.class);
        method.invoke(object1,object2);

    }

}
