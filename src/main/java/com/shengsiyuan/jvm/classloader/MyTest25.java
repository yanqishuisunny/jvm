package com.shengsiyuan.jvm.classloader;

import sun.misc.Launcher;

public class MyTest25 implements Runnable{

    private Thread thread;

    public MyTest25(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        ClassLoader classLoader = this.thread.getContextClassLoader();
        this.thread.setContextClassLoader(classLoader);
        System.out.println("Class:" + classLoader.getClass());
        System.out.println("Parent:" + classLoader.getParent().getClass());
    }

    /**
     *
     * @param arg
     * @throws Exception
     */
    public static void main(String[] arg) throws Exception {
        new MyTest25();

    }



}
