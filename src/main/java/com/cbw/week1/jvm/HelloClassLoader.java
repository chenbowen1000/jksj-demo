package com.cbw.week1.jvm;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author chenbowen
 * @date 2021/8/8 22:45
 */

public class HelloClassLoader extends ClassLoader{

    private static String CONFIG_FILE_PATH = "file/week1";

    public static void main(String[] args) {
        try {
            Class<?> helloClass = new HelloClassLoader().findClass("Hello");
            Method helloMethod = helloClass.getMethod("hello");
            helloMethod.invoke(helloClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Path path = Paths.get("F:/myRepertory/jksj-demo/file/week1/Hello.xlass");
        byte[] helloBase64 = new byte[0];
        try {
            helloBase64 = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < helloBase64.length; i++) {
            helloBase64[i] = (byte) (255 - helloBase64[i]);
        }

        return defineClass(name, helloBase64, 0, helloBase64.length);
    }

}
