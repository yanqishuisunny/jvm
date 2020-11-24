package com.shengsiyuan.jvm.classloader;

import java.io.*;

public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;


    public MyTest16(String classLoaderName) {
        super();//系统类加载器当做该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent); //显示指定该类加载器的父加载器
        this.classLoaderName = classLoaderName;
    }

    public MyTest16(ClassLoader parent) {
        super(parent);
    }

    @Override
    public String toString() {
        return "[" + this.classLoaderName + "]";
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("*********************************:");
        System.out.println("className:" + className);
        byte[] data = this.loadClassData(className);
        return this.defineClass(className, data, 0, data.length);
    }

    private byte[] loadClassData(String className) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        className = className.replace(".", "\\");
        try {
            is = new FileInputStream(new File(this.path + className + this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch;
            while (-1 != (ch = is.read())) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                baos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }

//    public static void test(ClassLoader classLoader) throws Exception{
//        Class<?> clazz = classLoader.loadClass("com.example.jvm.demo.jvm.MyTest2");
//        Object object = clazz.newInstance();
//        System.out.println(object);
//        System.out.println(object.getClass().getClassLoader());
//    }

    public static void main(String[] arg) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\xinyang\\Desktop\\");
        Class<?> clazz = loader1.loadClass("com.example.jvm.demo.jvm.Myparent2");
        System.out.println("class:" + clazz.hashCode());
        Object object = clazz.newInstance();
        System.out.println(object);
        System.out.println(object.getClass().getClassLoader());

//        MyTest16 loader2 = new MyTest16("loader2");
//        loader2.setPath("C:\\Users\\xinyang\\Desktop\\com\\example\\jvm\\demo\\jvm\\");
//        Class<?> clazz2 = loader2.loadClass("com.example.jvm.demo.jvm.MyTest2");
//        System.out.println("class:" + clazz.hashCode());
//        Object object2 = clazz.newInstance();
//        System.out.println(object2);
//        System.out.println(object2.getClass().getClassLoader());
    }


}
