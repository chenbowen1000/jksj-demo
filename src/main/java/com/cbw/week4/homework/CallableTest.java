package com.cbw.week4.homework;

import java.util.concurrent.*;

/**
 * @author chenbowen
 * @date 2021/8/28 23:13
 */
public class CallableTest {



    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        String method1 = method1(es);
        System.out.println(method1);
    }

    private static String method1(ExecutorService es) {
        try {
            java.util.concurrent.Future<String> submit = es.submit(new Task1());
            return submit.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static class Task1 implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("666");
            return "method1";
        }
    }
}
