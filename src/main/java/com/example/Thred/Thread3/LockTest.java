package com.example.Thred.Thread3;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * 描述:
 * LOCK测试类
 *
 * @author hongjw
 * @create 2019-12-30 22:04
 */
public class LockTest {

    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        Stream.of("t1","t2","t3","t4").forEach(t->{
            new Thread(()->{
                myLock.lock();
                System.out.println(Thread.currentThread().getName()+"线程下准备工作");
                worktest();
                myLock.unlock();
            },t).start();
        });
    }

    private static void worktest() {
        Optional.of("["+Thread.currentThread().getName()+"]正在工作").ifPresent(System.out::println);
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
