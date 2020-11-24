package com.shengsiyuan.jvm.gc;

/**
 * -verbose:gc  虚拟机中，垃圾回收比较详细的情况
 * -Xms20M      堆的初始大小
 * -Xmx20M      堆的最大大小
 * -Xmn10M      堆空间当中新生代打大小是10M
 * -XX:+PrintGCDetails  打印出垃圾回收详细的信息
 * -XX:SurvivorRatio=8  堆中eden空间大小
 * <p>
 * [PSYoungGen: 5751K->5751K(9216K)]
 * 13943K->13967K(19456K)
 * 0.0037018 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 */

/**
 * [PSYoungGen: 5751K->5751K(9216K)]
 * 13943K->13967K(19456K)
 * 0.0037018 secs] [Times: user=0.01 sys=0.00, real=0.00 secs]
 */

/**
 * 例1:
 * int size = 1024 * 1024;
 * byte[] myAlloc1 = new byte[2 * size];
 * byte[] myAlloc2 = new byte[2 * size];
 * byte[] myAlloc3 = new byte[3 * size];
 * System.out.println("hello world");
 * 7167-1023 = 6144 //执行完gc后，新生代释放的空间容量
 * 7167-5143 = 1024 //执行完gc后，总的堆空间释放的容量
 * 6144-1024 = 4120   ParOldGen    --total 10240K, used 4120K表示堆中的使用的空间
 */

/**
 * jdk1.8默认的垃圾收集器
 * PSYoungGen Parallel Scavenge (新生代垃圾收集器)
 * ParOldGen Parallel Old (老年代垃圾收集器)
 */
public class MyTest1 {
    public static void main(String[] arg) {
        int size = 1024 * 1024;
        byte[] myAlloc1 = new byte[2 * size];
        byte[] myAlloc2 = new byte[2 * size];
        byte[] myAlloc3 = new byte[3 * size];
        byte[] myAlloc4 = new byte[3 * size];
        System.out.println("hello world");
    }
}
