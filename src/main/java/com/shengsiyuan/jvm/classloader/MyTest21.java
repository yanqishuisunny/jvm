package com.shengsiyuan.jvm.classloader;

import java.lang.reflect.Method;

/**
 * 类的命名空间
 *
 * 类加载器的双亲委托模型好处:
 *
 * 1:可以确保Java核心库的类型安全:所有的Java应用都至少会引用java.long.Object类，也就是说明在运行期，java.lang.Object这个类
 *   会被加载到Java虚拟机忠；如果这个加载过程是由Java应用自己的类加载器所完成，那么很可能就会在JVM中存在多个版本的
 *   java.lang.Object类，而且这些类之前还是不兼容的，相互不可见(正是命名空间在发挥作用)。
 *   借助双亲委托机制，Java核心类库中的类的加载工作都是由启动类加载器来统一完成的，从而确保了Java应用所使用的都是同一个版本
 *   的Java核心类库，他们之间相是相互兼容的
 * 2:可以确保Java核心类库所提供的类不会被自定义的类所代替
 * 3:不同的类加载器可以为相同名称(binary name)的类创建额外的命名空间。相同名称的类可以并存在Java虚拟机中，只需要用不同的
 *   类加载器来加载他们即可。不同类加载器所加载的类之间是不兼容的，这就相当于在Java虚拟机内部创建了一个又一个相互隔离的Java
 *   类空间，这类技术在很多框架中都得到了实际应用
 *
 */
public class MyTest21 {

    public static void main(String[] arg) throws Exception {
        MyTest16 loader1 = new MyTest16("loader1");
        MyTest16 loader2 = new MyTest16("loader2");
        loader1.setPath("C:\\Users\\xinyang\\Desktop\\");
        loader2.setPath("C:\\Users\\xinyang\\Desktop\\");
        Class<?> clazz1 = loader1.loadClass("com.example.jvm.demo.jvm.MyPerson");
        Class<?> clazz2 = loader2.loadClass("com.example.jvm.demo.jvm.MyPerson");
        System.out.println(clazz1 == clazz2);
        /**
         * 删除MyPerson类，把文件拷.class文件拷贝到桌面，执行结果为false
         * 此时加载loader1和 loader2分别加载MyPerson，并且都是MyPerson的定义类加载器
         * 但是 loader1和loader2并没有关联关系，因此会形成俩个命名空间
         */
        Object object1 = clazz1.newInstance();
        Object object2 = clazz2.newInstance();
        Method method = clazz1.getMethod("setMyPerson", Object.class);
        //反射
        method.invoke(object1,object2);

    }

}
