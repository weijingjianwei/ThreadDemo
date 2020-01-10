package com.example.Thred.Thread4;

/**
 * 描述:
 * 锁工具
 *
 * @author hongjw
 * @create 2019-12-30 21:59
 */
public class MyLock {

    public boolean locked;

    private Thread currentThread;

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

    /**
     * lock锁,参数为过期时间,超过该时间则移除该线程
     * @param mills
     */
    public synchronized void lock(long mills) throws InterruptedException{
        if(mills<0){
            this.lock();
        }
        long endTime=System.currentTimeMillis()+mills;
        while (locked){
            if(endTime-System.currentTimeMillis()<=0){
                throw new InterruptedException();
            }
            this.wait(mills);

        }
        //将标志位置为true
        this.currentThread=Thread.currentThread();
        this.locked=true;
    }

    public synchronized void unlock(){
        //判断只有当前的线程才能释放当前锁
        if(Thread.currentThread()==this.currentThread){
            locked=false;
            this.notifyAll();
        }
    }
}
