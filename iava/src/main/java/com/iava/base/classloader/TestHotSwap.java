package com.iava.base.classloader;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class TestHotSwap {
public static void main(String args[]) throws Exception {
    A a = new A();
    B b = new B();
    a.setB(b);
 
    System.out.printf("A classLoader is %s n \r" , a.getClass().getClassLoader());
    System.out.printf("B classLoader is %s n \r" , b.getClass().getClassLoader());
    System.out.printf("A.b classLoader is %s n \r" ,   a.getB().getClass().getClassLoader());
 
    HotSwapClassLoader c1 = new HotSwapClassLoader( new URL[]{ new URL("file:F:/personal/wps快盘/我的资料/workspace/iava/iava/target/classes/")} , a.getClass().getClassLoader());
    Class clazz = c1.load("com.iava.base.classloader.A");
    Object aInstance = clazz.newInstance();
    Method method1 = clazz.getMethod("setB", B.class);
    method1.invoke(aInstance, b);
 
    Method method2 = clazz.getMethod("getB", null);
    Object bInstance = method2.invoke(aInstance, null);
  
    System.out.printf("aInstance classLoader is %s \r",aInstance.getClass().getClassLoader());
    System.out.printf(" reloaded A.b classLoader is %s \n", bInstance.getClass().getClassLoader());
}
}