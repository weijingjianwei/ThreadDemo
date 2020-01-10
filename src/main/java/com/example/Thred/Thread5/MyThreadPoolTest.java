package com.example.Thred.Thread5;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * 描述:
 * 自定义线程测试类
 *
 * @author hongjw
 * @create 2020-01-03 15:45
 */
public class MyThreadPoolTest {

    public static AtomicInteger atomicInteger=new AtomicInteger(0);
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool();
        IntStream.rangeClosed(1,50).forEach(index->{
            myThreadPool.submitRunable(new Runnable() {
                @Override
                public void run() {
                    dowork();
                }
            });
        });

//        new test2().run();
//        new Thread(new test2()).start();
//        try {
//            Thread.sleep(20_000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("运行完的总线程数为:"+atomicInteger.get());
    }

    //线程各自执行的方法
    private static void dowork() {

        System.out.println(Thread.currentThread().getName()+"-start");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-end");
        atomicInteger.incrementAndGet();
    }

    public static class test2 implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
