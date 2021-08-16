package com.cbw.week1.jvm;

import com.cbw.constants.CommonConstants;

import java.io.File;
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

    public static void main(String[] args) {
        try {
            Class<?> helloClass = new HelloClassLoader().findClass("Hello");
            Method helloMethod = helloClass.getMethod("hello");
            helloMethod.invoke(helloClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a() {
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //Path path = Paths.get("F:/myRepertory/jksj-demo/file/week1/Hello.xlass");
        Path path = Paths.get(new File(
                CommonConstants.CONFIG_FILE_PATH + "Hello.xlass").getPath());
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