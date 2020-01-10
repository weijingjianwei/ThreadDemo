package com.example.Thred;

import java.util.stream.IntStream;

/**
 * 描述:
 * 杂项测试
 *
 * @author hongjw
 * @create 2020-01-05 14:57
 */
public class Thread6 {

    private static Object object = new Object();
    public static void main(String[] args) {

        IntStream.rangeClosed(1, 10).forEach(i ->
                    new Thread() {
                        @Override
                        public void run() {
                            synchronized (object) {
                                System.out.println(currentThread().getName() + "  start.....");
                                try {
                                    object.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                System.out.println(currentThread().getName() + "  end......");
                            }

                        }
                    }.start()


        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println(currentThread().getName() + "  notify.....");
                    object.notifyAll();
                }
            }

        }.start();
    }
}
