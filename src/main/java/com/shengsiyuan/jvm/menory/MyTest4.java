package com.shengsiyuan.jvm.menory;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * 方法去产生内存溢出错误
 *
 * 设置元空间最大值: -XX:MaxMetaspaceSize=200M -XX:+TraceClassLoading
 */
public class MyTest4 {

    public static void main(String[] args){
        for(; ;){
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(MyTest4.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)(obj,method,args1,proxy)->
                    proxy.invokeSuper(obj,args1));
            System.out.println("hello world");
            enhancer.create();
        }
    }

}








