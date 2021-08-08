package com.cbw.week1.jvm;

import sun.misc.Launcher;

import java.net.URL;
import java.util.Arrays;

/**
 * @author chenbowen
 * @date 2021/8/8 21:34
 */
public class jvmDemo {
    public static void main(String[] args) {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        System.out.printf("启动类加载器");
        Arrays.stream(urLs).forEach(System.out::println);
    }
}
