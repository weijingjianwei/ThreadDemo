package com.example.Volatitle;

/**
 * 描述:
 * test1
 *
 * @author hongjw
 * @create 2020-01-07 19:29
 */
public class Test1 implements Runnable {

    public static  boolean flag=true;
    @Override
    public void run() {
        while (flag){
            System.out.println("start ...........");
        }
        System.out.println("ending.....");
    }
}
