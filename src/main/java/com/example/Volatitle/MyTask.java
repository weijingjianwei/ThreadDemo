package com.example.Volatitle;

/**
 * 描述:
 * MyTask
 *
 * @author hongjw
 * @create 2020-01-07 19:55
 */
public class MyTask implements Runnable{
    private volatile boolean flag = false;

    // 修改值
    @Override
    public void run() {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag=" + flag);
    }

    public boolean isFlag() {
        return flag;
    }
}
