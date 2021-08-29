package com.cbw.week4;

/**
 * @author chenbowen
 * @date 2021/8/28 22:18
 */
public class Thread1 {


    public static void main(String[] args) {
        Runnable task = () -> {
            try {

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("666666");

        };
        Thread t = Thread.currentThread();
        //String name = t.getName();
        System.out.println("当前线程"+t.getName());

        //thread.start();

        Thread thread = new Thread(task);
        thread.setName("myThread");
        //thread.setDaemon(true);
        thread.start();
        System.out.println(thread.getName());


        try {
            t.wait();
            //Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
