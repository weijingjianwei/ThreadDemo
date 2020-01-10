package com.example.Thred.Thread3;

/**
 * 描述:
 * 锁工具
 *
 * @author hongjw
 * @create 2019-12-30 21:59
 */
public class MyLock {

    public boolean locked;

    public synchronized void lock(){
        System.out.println(Thread.currentThread().getName()+"线程抢到锁了");
        while (locked){
            try {
                System.out.println(Thread.currentThread().getName()+"线程waitz住了");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        locked=true;
    }

    public synchronized void unlock(){
        locked=false;
        this.notifyAll();
    }
}
