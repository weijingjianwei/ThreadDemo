package com.example.Thred.Thread5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.IntStream;

/**
 * 描述:
 * 线程池
 *
 * @author hongjw
 * @create 2020-01-03 15:19
 */
public class MyThreadPool {

    private int poolsize;

    private final ThreadGroup threadGroup=new ThreadGroup("myThreadPool-ThreadGroup");
    private static final String THREADHEADER = "MyThreadPool-Thread-index-";
    //runable 容器结合
    private static LinkedList<Runnable> runnables=new LinkedList<>();

    //线程容器
    private static ArrayList<Thread> threads=new ArrayList<>();

    public MyThreadPool(int size) {
        this.poolsize=size;
        init();
    }

    public MyThreadPool(){
        this.poolsize=10;
        init();
    }

    //初始化方法
    private void init() {
        //构造线程池中的线程
        IntStream.rangeClosed(1,this.poolsize)
                .forEach(index->{
                            myTread myTread = new myTread(threadGroup, THREADHEADER + index);
                            myTread.start();
                            threads.add(myTread);
                        }
                );
    }

    public void submitRunable(Runnable runnable){
        synchronized (runnables){
            if(runnables.size()>10) throw new RuntimeException("该任务作废"+Thread.currentThread().getName());
            System.out.printf("runable总数量%d",runnables.size());
            runnables.addLast(runnable);
            //唤醒被锁定的线程
            runnables.notifyAll();
        }



    }

    private class myTread extends Thread{

        public myTread(ThreadGroup threadgroup,String name){
            super(threadgroup,name);
        }

        @Override
        public void run() {
           Runnable runnable;
           while(true){
               synchronized (runnables){
                   while (runnables.isEmpty()){
                       try {
                           runnables.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }

                   }
                   //拿到runable 结合，运行线程方法
                   runnable=runnables.removeFirst();
               }
               runnable.run();
           }
        }
    }
}
