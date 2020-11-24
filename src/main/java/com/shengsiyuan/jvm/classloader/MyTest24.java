package com.shengsiyuan.jvm.classloader;


public class MyTest24 {

    /**
     * 当前类加载器(Current Classloader)
     *
     * 每个类都会使用自己的类加载器(既加载自身的类加载器)来去加载其他类(指的是所依赖的类)
     * 如果ClassX引用了ClassY,那么ClassX的类加载器就回去加载ClassY(前提是ClassY尚未被加载)
     *
     * 线程上下文类加载器(Context Classloader)
     *
     * 线城上下文类加载器是从JDK 1.2开始引入的，类Thread中的getContextClassLoader()与setContextClassLoader(ClassLoader c1)
     * 分别用来获取和设置上下文加载器。
     *
     * 如果没有通过serContextClassLoader(ClassLoader c1)进行设置的话，线城将继承其父线程的上下文类加载器。
     * Java应用运行时的初始线城的上线文类加载器时系统类加载器。在线城中运行的代码可以通过该类加载器来加载类与资源。
     *
     * 线程上下文类加载器的重要性:
     *
     * SPI(Service Provider Interface)
     *
     * 父ClassLoader可以使用当前线程Thread.currentThread().getContextClassLoader()所指定的classloader加载的类。
     * 这就改变了父ClassLoader不能使用子ClassLoader或是其他没有直接父子关系的ClassLoader加载的类的情况，既改变了
     * 双亲委托模型。
     *
     * 线程上下文加载器就是当前线程的Current Classloader.
     *
     * 在双亲委托模型下，类加载是由下至上的，既下层的类加载器会委托给上层进行加载。但对于SPI来说，有些接口时核心类库所提供的，
     * 而Java核心库是由启动类加载器来加载的，而这些接口的实现却来自于不同的jar包（厂商提供），Java的启动类加载器时不会加载其他
     * 来源的jar包，这样传统的双亲委托模型就无法满足SPI的要求。而通过给当前线程设置上线文类加载器，就可以由设置的上下文类加载器
     * 来实现对于接口实现类的加载
     *
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
        System.out.println(Thread.currentThread().getContextClassLoader());
        System.out.println(Thread.class.getClassLoader());



    }









}
