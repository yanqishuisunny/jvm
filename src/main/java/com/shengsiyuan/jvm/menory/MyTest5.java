package com.shengsiyuan.jvm.menory;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * 方法去产生内存溢出错误
 */

/**
 * window下查看java进程命令 : tasklist | findstr "java"
 * jmap -clstats PID 打印类加载器数据
 * ******************************************
 * <p>
 * 获取jvm进程信息
 * jps -help
 * jps -l : 查看运行的java类线程
 * jps [-q] [-mlvV]
 * ******************************************
 * jcmd -help
 * or: jcmd -l
 * or: jcmd -h
 * ******************************************
 * 查看某个进行的信息(jcmd)
 * jcmd pid help : 列出当前运行的Java进程可以执行的操作
 * jcmd pid VM.flags : 查看JVM启动参数
 * jcmd pid help JFR.dump : 查看具体命令选项
 * jcmd pid PerfCounter.print : 查看JVM性能相关参数
 * jcmd pid VM.uptime : 查看JVM启动时长
 * jcmd pid GC.class_histogram : 查看系统中类的统计信息
 * jcmd pid Thread.print : 查看线程堆栈信息
 * jcmd pid GC.class_histogram : 查看系统中类的统计信息
 * jcmd pid GC.heap_dump + 路径(C:\Users\xinyang\Desktop\hello.hprof)  --window下生产dump文件
 * jcmd pid VM.system_propetties : 查看JVM属性信息
 * jcmd pid VM.command_line : 查看JVM启动的命令行参数信息
 * ********************************************
 * jatack: 可以查看或是导出Java应用程序中线程的堆栈信息
 *
 * *********************************************
 * jmc : Java Mission Control
 */
public class MyTest5 {

    public static void main(String[] args) {
        for (; ; ) {
            System.out.println("hello world");
        }
    }

}








