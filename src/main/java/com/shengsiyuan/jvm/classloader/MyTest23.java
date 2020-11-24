package com.shengsiyuan.jvm.classloader;

import sun.misc.Launcher;

public class MyTest23 {

    /**
     * 在运行时，一个java类是由该类的完全限定名(binary name,二进制名)和用于加载该类的定义类加载器（defining loader）所共同决定的
     * 如果同样名字(既相同的完全限定名)时类是由俩个不同的加载器所加载，那么这些类就是不同的，即使.class文件的字节码完全一样，并且从相同的
     * 位置加载亦如此
     *
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        /**
         * 内建于JVM中的启动类加载器会加载java.lang.ClassLoader以及其他的java平台类，
         * 当JVM启动时，一块特殊的机器码会运行，他会加载扩展类加载器与系统类加载器，
         * 这块特殊的机器码叫做启动类加载器(Bootstrap)
         *
         * 启动类加载器并不是Java类，而其他的加载器都是Java类，
         * 启动类加载器时特定于平台的机器指令，他负责开启整个加载过程。
         *
         * 所有类加载器(除了启动类加载器)都被实现我Java类。不过，总归要有一个组件来加载第一个Java类加载器，从而让整个加载过程能够顺利
         * 进行下去，加载第一个纯Java类加载器就是启动类加载器的职责
         *
         * 启动类加载器还会负责加载共JRE正常运行所需要的基本组件，这包括java.util与java.lang包中的类等等
         *
         */
        System.out.println(ClassLoader.class.getClassLoader());

        //扩展类加载器与系统类加载器也是由启动类加载器加载的
        System.out.println(Launcher.class.getClassLoader());

        System.out.println("------------------");

        System.out.println(System.getProperty("java.system.class.loader"));

        System.out.println(MyTest23.class.getClassLoader());

        System.out.println(MyTest16.class.getClassLoader());

        System.out.println(ClassLoader.getSystemClassLoader());



    }




}
