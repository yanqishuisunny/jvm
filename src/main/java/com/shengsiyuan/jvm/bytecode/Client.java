package com.shengsiyuan.jvm.bytecode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *  * <li>An invocation of the {@code hashCode},
 *         * {@code equals}, or {@code toString} methods declared in
 *         * {@code java.lang.Object} on a proxy instance will be encoded and
 *         * dispatched to the invocation handler's {@code invoke} method in
 *         * the same manner as interface method invocations are encoded and
 *  * dispatched, as described above.  The declaring class of the
 *  * {@code Method} object passed to {@code invoke} will be
 *         * {@code java.lang.Object}.  Other public methods of a proxy
 *         * instance inherited from {@code java.lang.Object} are not
 *         * overridden by a proxy class, so invocations of those methods behave
 *         * like they do for instances of {@code java.lang.Object}.
 */


public class Client {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles","true");

        RealSubject rs = new RealSubject();
        InvocationHandler ds = new DynamicSubject(rs);
        Class<?> cls = rs.getClass();
        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ds);
        subject.request();
        System.out.println(subject.getClass());
    }
}
