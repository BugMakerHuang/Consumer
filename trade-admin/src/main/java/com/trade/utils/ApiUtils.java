package com.trade.utils;

/**
 * 此工具类用于练习各种Java Api用法
 * @author ZhenYu.Ben
 */
public class ApiUtils {

    /**
     * 静态代码块的意义在于在程序运行之前直接执行代码块里运行
     * 1.类加载的过程 BootStrapClassLoader (C++) -> ExtClassLoader  -> AppClassLoader
     * 每种类加载起都有自己的加载目录
     * 2.双亲委派机制
     *   ① 每个类加载器对他加载过的类都有一个缓存。
     *   ② 向上委托查找，向下委托加载.
     */
    static {
        System.out.println("Hello! This is for Api trainning");
    }

    private static final String finalStaticString = "~~~~~~~~~~~ FinalStaticString!";

    private static String staticString = "~~~~~~~~~~ StaticString!";

    public void testForFinalStaticString(){

    }

}
