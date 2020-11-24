package com.shengsiyuan.jvm.classloader;


/**
 * 关于命名空间的重要说明
 *
 * 1.子加载器加载的类能够访问父加载器所加载的类
 * 2.父加载器所加载的类无法访问到子加载器所加载的类
 *
 */
public class MyTest17_1 {

    public static void main(String[] arg) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        loader1.setPath("C:\\Users\\xinyang\\Desktop\\");
        Class<?> clazz = loader1.loadClass("com.example.jvm.demo.jvm.MySample");
        System.out.println("class:" + clazz.hashCode());

        //如果注释掉该行，那么并不会实例化MySample对象，既MySample构造方法不会被调用
        //因此不会实例化MyCat对象，既没有对MyCat进行主动使用，这里就不会加载MyCat Class
        Object object = clazz.newInstance();
    }

}
