package com.shengsiyuan.jvm.classloader;

import java.sql.Driver;
import java.util.Iterator;
import java.util.ServiceLoader;

public class MyTest26 {

    /**
     * 线程上线文类加载器的一般使用模式(获取 - 使用 - 还原)
     *
     * ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
     * try{
     *    Thread.currentThread().setContextClassLoader(targetTccl);
     * myMethoe();
     * } finally {
     * Thread.currentThread().setContextClassLoader(classLoader);
     * }
     *
     * myMethod里面则调用了hread.currentThread().setContextClassLoader(),获取当前线程的上下文类加载器做
     * 某些事情。
     *
     * 如果一个类由类加载器A加载，那么这个类的依赖类也是由相同的类加载器加载的（如果该依赖类之前没有被加载过的话）
     * ContextClassLoader的作用就是为了破坏Java的类加载委托机制
     *
     * 当高层提供了统一的接口让底层去实现，同时又要在高层加载(或实例化)底层的类时，就必要要通过线程上下文类加载器
     * 来帮助高层ClassLoader找到并加载类
     */


    public static void main(String[] arg) throws Exception {
//        Thread.currentThread().setContextClassLoader(MyTest26.class.getClassLoader().getParent());

        ServiceLoader<Driver> loader = ServiceLoader.load(Driver.class);
        Iterator<Driver> iterable = loader.iterator();
        while(iterable.hasNext()){
            Driver driver = iterable.next();
            System.out.println("driver:" + driver.getClass() + "loader:" + driver.getClass().getClassLoader());
        }
        System.out.println("当前线程上下文类加载器:" + Thread.currentThread().getContextClassLoader());
        System.out.println("ServiceLoader的类加载器：" + ServiceLoader.class.getClassLoader());
    }


}
