package com.trade.utils;

/**
 * 此工具类用于练习各种Java Api用法
 * @author ZhenYu.Ben
 */
public class ApiUtils {

    /**
     * 静态代码块的意义在于在程序运行之前直接执行代码块里运行
     * 1.JAVA的类加载的过程
     *    BootStrapClassLoader (C++) -> ExtClassLoader  -> AppClassLoader
     *    每种类加载起都有自己的加载目录
     * 2.双亲委派机制
     *   ① 每个类加载器对他加载过的类都有一个缓存。
     *   ② 向上委托查找，向下委托加载.
     * 3.JDK的类加载对象
     *    ClassLoader -> SecureClassLoader -> URLClassLoader -> ExtClassLoader,AppClassLoader
     */
    static {
        System.out.println("Hello! This is for Api trainning");
    }

    private static final String finalStaticString = "~~~~~~~~~~~ FinalStaticString!";

    private static String staticString = "~~~~~~~~~~ StaticString!";

    private static int count = 0;

    public static void recursion(int a,int b,int c){
       long  l1 = 12;
       short s1 = 1;
       byte  b1 = 1;
       String s = "1";
       System.out.println("count="+count);
       count++;
       recursion(1,2,3);
    }

    public static void recursion(){
        System.out.println("count="+count);
        count++;
//        recursion();
    }

    public void localvarGc1() {
        byte[] a = new byte[6*1024*1024];
        System.gc();
    }

    public void localvarGc2() {
        byte[] a = new byte[6*1024*1024];
        a=null;
        System.gc();
    }

    public void localvarGc3(){
        {
            byte[] a = new byte[6*1024*1024];
        }
        System.gc();
    }

    public void localvarGc4() {
        {
            byte[] a = new byte[6*1024*1024];
        }
        int c = 10;
        System.gc();
    }

    public void localvarGc5() {
        localvarGc1();
        System.gc();
    }




}
