package com.example.Thred.Thread2;

/**
 * 描述:
 * 测试银行类
 *
 * @author hongjw
 * @create 2019-12-28 15:29
 */
public class Bank {
    public static void main(String[] args) throws InterruptedException {
        PicketWindows picketWindows1 = new PicketWindows("1号柜台");
        PicketWindows picketWindows2 = new PicketWindows("2号柜台");
        PicketWindows picketWindows3 = new PicketWindows("3号柜台");

        for (int i = 1; i < 1000; i++) {
            new Thread(new PicketWindows(i+"号柜台")).start();
        }

//        new Thread(picketWindows1).start();
//        new Thread(picketWindows2).start();
//        new Thread(picketWindows3).start();
//
        Thread.sleep(10000);
        System.out.println(picketWindows1.total);
        System.out.println(picketWindows1.map.size());
    }
}
