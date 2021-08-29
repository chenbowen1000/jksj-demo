package com.cbw.week4.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

/**
 * @author chenbowen
 * @date 2021/8/30 1:34
 */
public class CountDownLatchTest {


    public static void main(String[] args) throws Exception{
        int num  = 100;
        CountDownLatch countDownLatch = new CountDownLatch(num);
        List<CompletableFuture> completableFutureList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            CompletableFuture<Void> future =
                    CompletableFuture.runAsync(new CountDownLatchTask(countDownLatch));

            completableFutureList.add(future);
        }
        countDownLatch.await();

        //TODO 为啥这里不能通过流去遍历？java: 未报告的异常错误java.lang.InterruptedException;
        // 必须对其进行捕获或声明以便抛出，但是已经在try catch里面了

        //completableFutureList.parallelStream().forEach(n->n.get());

        for(CompletableFuture future:completableFutureList){
            future.get();
        }
    }

    public static class  CountDownLatchTask implements Runnable{

        private CountDownLatch countDownLatch;

        public CountDownLatchTask(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }


        @Override
        public void run() {
            //System.out.println("当前线程:"+Thread.currentThread().getName());
            this.countDownLatch.countDown();
        }
    }
}
