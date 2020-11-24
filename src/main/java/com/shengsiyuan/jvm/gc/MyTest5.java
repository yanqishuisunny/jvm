package com.shengsiyuan.jvm.gc;

public class MyTest5 {
    /**
     * -verbose:gc
     * -Xms20M
     * -Xmx20M
     * -Xmn10M
     * -XX:+PrintGCDetails
     * -XX:SurvivorRatio=8
     * -XX:+UseConcMarkSweepGC
     * @param arg
     */
    /**
     *  [GC (CMS Final Remark)
     *  [YG occupancy: 6460 K (9216 K)]:年轻代占用的空间
     *  [Rescan (parallel) , 0.0002375 secs]:重新进行扫描
     *  [weak refs processing, 0.0000844 secs]:对弱引用的处理
     *  [class unloading, 0.0005098 secs]
     *  [scrub symbol table, 0.0007985 secs]
     *  [scrub string table, 0.0002207 secs]
     *  [1 CMS-remark: 9031K(10240K)] 15491K(19456K), 0.0020462 secs]
     *  [Times: user=0.00 sys=0.00, real=0.00 secs]
     * @param arg
     */
    public static void main(String[] arg) {
        int size = 1024 * 1024;

        byte[] myAllocl = new byte[4 * size];

        System.out.println("111111");

        byte[] myAlloc2 = new byte[4 * size];

        System.out.println("222222");

        byte[] myAlloc3 = new byte[4 * size];

        System.out.println("333333");

        byte[] myAlloc4 = new byte[2 * size];

        System.out.println("444444");
    }
}
