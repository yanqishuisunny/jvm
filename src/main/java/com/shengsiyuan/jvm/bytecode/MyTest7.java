package com.shengsiyuan.jvm.bytecode;

/**
 * 针对于方法调用动态分派的过程，虚拟机会在类的方法区建立一个虚方法表的数据结构(vritual method table,vtable),
 * 针对invokeinterface指令来说，虚拟机会会建立一个叫做接口方法表的数据结构(interface method table,itable)
 */

import java.util.Date;

public class MyTest7 {

    public static void main(String[] args){
        Animal animal = new Animal();
        Animal dog= new Dog();
        animal.test("hello");
        dog.test(new Date());
    }
}

class Animal{

    public void test(String str){
        System.out.println("animal str");
    }

    public void test(Date data){
        System.out.println("animal data");
    }
}

class Dog extends Animal{

    public void test(String str){
        System.out.println("dog str");
    }

    public void test(Date data){
        System.out.println("data data");
    }
}









