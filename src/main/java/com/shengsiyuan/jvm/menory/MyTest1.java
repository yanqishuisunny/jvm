package com.shengsiyuan.jvm.menory;

import java.util.ArrayList;
import java.util.List;

/**
 *  虚拟机栈 : Stack Prame 栈帧  (存在局部变量表,用于存放八个原生数据类型，和引用类型[其引用(StrongReference)，软引用(SoftReference)，弱引用(WeakReference)以及PhantomReference(虚引用)])
 *  程序计数器  (Program Counter) 描述字节码执行顺序
 *  本地方法栈 : 主要用于处理本地方法 主要用于描述本地方法(native方法)
 *  堆(Heap) : JVM管理的最大一块内存空间,与堆相关的一个重要概念是垃圾收集器。现代几乎所有的垃圾收集器都是采用的分代收集算法。所以，堆空间也
 *  基于这一点进行了相应的划分: 新生到和老年代。Eden空间，From Survivor 空间与 To Survivor空间
 *  方法区 (Method Area) : 存储元信息和类型信息。永久代(Permanent Generation),从jdk 1.8开始，已经彻底废弃了永久代。使用元空间(metaSpace)
 *  运行时常量池 : 方法区的一部分内容 （编译期间就能确定好的，包括一些常量和符号引用等)
 *  直接内存 : Direct Memory (并不是由jvm直接管理的内存，而是由操作系统管理的。jvm只是向操作系统去申请这部分内容）
 *
 *  关于Java对象创建的过程：
 *   new关键字创建对象的3个步骤:
 *   1.在堆内存中创建出对象的实例。
 *   2.为对象的实例成员变量赋初值。(调用init方法)
 *   3.将对象的引用返回
 *   指针碰撞(前提是堆中的空间通过一个指针进行分割，一侧是已经被占用的空间，另一侧是未被占用的空间)
 *   空闲列表(前提是堆内存空间中已被使用与未被使用的空间是交织在一起的，这时，虚拟机就需要通过一个列表来记录哪些空间是可以
 *   使用的，哪些空间是已被使用的，接下来找出可以容纳下新创建对象的且未被使用的空间，在此空间存放该对象，同时还要修改列表
 *   上的记录)
 *
 *   对象在内存中的布局
 *   1:对象头
 *   2:实例数据(既我们在一个类中所声明的各项信息)
 *   3:对齐填充(可选)
 *
 *   引用访问对象的方式 : 1:句柄的方式 2:直接指针的方式
 *
 *   -Xms1m -Xms1m -XX:+HeapDumpOnOutOfMemoryError
 *   -Xms
 *   初始Heap大小
 *   -Xmx
 *   java heap最大值
 */
public class MyTest1 {

    public static void main(String[] arg){
        List<MyTest1> list = new ArrayList<>();

        for( ; ; ){
            list.add(new MyTest1());
        }
    }



}








