package com.example.Volatitle;

import java.util.Optional;

/**
 * 描述:
 * volatitle测试2
 *
 * @author hongjw
 * @create 2020-01-07 19:12
 */
public class Voliatitle2 {
    private static boolean flag=true;
    static int i=0;

    public static void main(String[] args) {
        new Thread(()->{
            while (flag){
                System.out.println(i++);
            }
            System.out.println("====================");
            System.out.println("game over");
        }).start();

//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
////            flag=false;
//        System.out.println("ending.......");

//        Thread thread = new Thread(new Test1());
//        thread.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Test1.flag=false;
//        System.out.println("flag 置为 flase");


    }


//    class Test1 implements Runnable{
//
//        public static  boolean flag=true;
//        @Override
//        public void run() {
//            while (flag){
//
//            }
//            System.out.println("ending.....");
//        }
//    }
}
