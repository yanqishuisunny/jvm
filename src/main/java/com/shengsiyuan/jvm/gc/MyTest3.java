package com.shengsiyuan.jvm.gc;

/**
 * -verbose:gc
 * -Xms20M
 * -Xmx20M
 * -Xmn10M
 * -XX:+PrintGCDetails
 * -XX:+SurvivorRatio=8
 * -XX:+PrintCommandLineFlags
 * -XX:MaxTenuringThreshold=5 作用:在可以自动调节对象晋升(Promote)到老年代阈值的gc中，设置阈值的最大值
 * 该参数的默认值为15，CMS中默认值为6，G1中默认为15(在JVM中，该数值是由4个bit来表示的，所以最大值1111.既15)
 * 经历过多次GC后，存活的对象会在From Suivivor与To Survivor之间来回存放，而这里面的一个前提则是这俩个空间有
 * 足够的大小来存放这些数据，在GC算法中，会计算每个对象年龄的大小，如果达到某个年龄后发现总大小已经大于了
 * Survivor空间的50%，那么这时就需要调整阀值，不能在继续等到默认的15次GC后才完成晋升，因为这样会导致Survivor
 * 空间不足，所以需要调整阀值，让这些存活对象尽快完成晋升
 * -XX:+PrintTenuringDistribution
 */
public class MyTest3 {
    public static void main(String[] arg) {
        int size = 1024 * 1024;
        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[2 * size];
        byte[] myAlloc4 = new byte[2 * size];
        System.out.println("hello world");
    }
}
