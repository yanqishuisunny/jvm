package com.shengsiyuan.jvm.bytecode;

public class MyTest2 {

    String str = "Welcome";  //在构造方法中产生，构造方法就是对这个类进行初始化。

    private  int x = 5;   //在构造方法中产生

    public static Integer in = 10;   //在<clinit>方法中产生

    /**
     * 一个类如果没有构造方法，编译器会为我们生产默认的构造方法。同时将成员变量的赋值
     * 放入构造方法中。如果我们自己提供了构造方法，编译器同时会将成员变量的赋值放入构
     * 造方法中，有几个构造方法就放几次
     */
    public MyTest2(){

    }

    public MyTest2(int i){
        System.out.println("aaa");
    }

    public static void main(String[] args){
        MyTest2 myTest2 = new MyTest2();

        myTest2.setX(8);

        in = 20;
    }

    private synchronized void setX(int x) {
        this.x = x;
    }

    private void test(String str){
        synchronized (str){
            System.out.println("hello world");
        }
    }

    private synchronized static void test2(){

    }
}

















