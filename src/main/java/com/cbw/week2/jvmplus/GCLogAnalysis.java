package com.cbw.week2.jvmplus;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author chenbowen
 * @date 2021/8/15 23:42
 */
public class GCLogAnalysis {
    private static Random  random = new Random();

    public static void main(String[] args) {
        long startMills = System.currentTimeMillis();
        long timeoutMills = TimeUnit.SECONDS.toMillis(2);
        long endMills = startMills+timeoutMills;
        LongAdder counter = new LongAdder();
        System.out.println("正在执行========");

        int cacheSize = 2000;
        Object[] cacheGarbage =  new Object[cacheSize];

        while(System.currentTimeMillis()<endMills){
            Object garbage = createGarbage(100 * 1024);
            counter.increment();
            int randomIndex = random.nextInt(2 * cacheSize);
            if(randomIndex<cacheSize){
                cacheGarbage[randomIndex] = garbage;
            }
        }

        System.out.println("执行结束！共生成对象次数:" +counter.longValue());

    }


    private static Object createGarbage(int max){
        int randomSize  = random.nextInt(max);
        int type = randomSize % 4;
        Object result = null;

        switch (type){
            case 0:
                result = new int[randomSize];
                break;
            case 1:
                result = new byte[randomSize];
            case 2:
                result = new double[randomSize];
            default:
                StringBuffer stringBuffer = new StringBuffer();
                String randomString = "Hello world";

                while (stringBuffer.length()<randomSize){
                    stringBuffer.append(randomString);
                    stringBuffer.append(max);
                    stringBuffer.append(randomSize);
                }
        }
        return result;
   }
}
