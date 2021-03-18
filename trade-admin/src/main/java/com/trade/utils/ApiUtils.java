package com.trade.utils;

/**
 * 此工具类用于练习各种Java Api用法
 * @author ZhenYu.Ben
 */
public class ApiUtils {

    /**
     * 静态代码块的意义在于在程序运行之前直接执行代码块里运行
     * 类加载的过程 BootStrapClassLoader (C++) -> ExtClassLoader  -> AppClassLoader
     */
    static {
        System.out.println("Hello! This is for Api trainning");
    }

    private static final String finalStaticString = "~~~~~~~~~~~ FinalStaticString!";

    private static String staticString = "~~~~~~~~~~ StaticString!";

    public void testForFinalStaticString(){

    }

}
