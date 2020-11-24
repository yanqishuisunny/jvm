package com.shengsiyuan.jvm.gc;

public class MyTest4 {

    /**
     * -verbose:gc
     * -Xmx200M
     * -Xmn50M  堆空间当中新生代打大小是10M
     * -XX:TargetSurvivorRatio=60 当某个Survivor空间中所存活的对象占据整个空间的60%，
     * 那么就会从新计算对象晋升到老年代的阈值。就不会用MaxTenuringThreshold设置的值
     * -XX:+PrintTenuringDistribution 打印出对象在Survivor中年龄的情况
     * -XX:+PrintGCDetails
     * -XX:+PrintGCDateStamps 打印出执行gc的时间戳
     * -XX:+UseConcMarkSweepGC 指定老年代垃圾收集器
     * -XX:+UseParNewGC 指定新生代垃圾收集器
     * -XX:MaxTenuringThreshold=3 对象在新生代存活的最大的年龄的预值是3
     * @param arg
     * @throws InterruptedException
     */
    public static void main(String[] arg) throws InterruptedException {
        byte[] byte_1 = new byte[512 * 1024];
        byte[] byte_2 = new byte[512 * 1024];
        myGc();
        Thread.sleep(1000);
        System.out.println("111111");
        myGc();
        Thread.sleep(1000);
        System.out.println("222222");
        myGc();
        Thread.sleep(1000);
        System.out.println("333333");
        myGc();
        Thread.sleep(1000);
        System.out.println("444444");
        byte[] byte_3 = new byte[1024 * 1024];
        byte[] byte_4 = new byte[1024 * 1024];
        byte[] byte_5 = new byte[1024 * 1024];
        myGc();
        Thread.sleep(1000);
        System.out.println("55555");
        myGc();
        Thread.sleep(1000);
        System.out.println("66666");

        System.out.println("hello world");
    }

    private static void myGc(){
        for(int i = 0; i < 40; i++){
            byte[] byteArray = new byte[ 1024 * 1024];
        }
    }
}
