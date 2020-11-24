package com.shengsiyuan.jvm.classloader;

/**
 * 常量在编译阶段会存入到调用这个常量的方法所在的类的常量池中，
 * 本质上，调用类并没有直接引用到定义常量的类，因此并没有触发
 * 定义常量的类的初始化
 * 注意:这里指的是将常量存放到了MyTest2的常量池中，之后MyTest2与Myparent2就没有任何关系了
 * 甚至，我们可以将Myparent2的class文件删除
 */
public class MyTest2 {
    public static void main(String[] arg){
        System.out.println(Myparent2.str);
    }
}


class Myparent2{

    public static final String str = "hello word";

    static {
        System.out.println("Myparent2 static block");
    }
}
