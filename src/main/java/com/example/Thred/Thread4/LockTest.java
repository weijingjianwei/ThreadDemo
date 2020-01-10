package com.example.Thred.Thread4;

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
                try {
                    myLock.lock(10000);
                    worktest();
                } catch (InterruptedException e) {
                    Optional.of("当前线程["+Thread.currentThread().getName()+"]有脾气了,我不等了,哼!")
                    .ifPresent(System.out::println);
                }finally {
                    myLock.unlock();
                }
            },t).start();
        });
    }

    private static void worktest() {
        Optional.of("["+Thread.currentThread().getName()+"]正在工作").ifPresent(System.out::println);
        try {
            Thread.sleep(5000);
            Optional.of("["+Thread.currentThread().getName()+"]结束工作").ifPresent(System.out::println);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
