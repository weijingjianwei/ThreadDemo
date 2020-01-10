package com.example.Thred.Thread1;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述:
 * 票窗
 *
 * @author hongjw
 * @create 2019-12-28 15:24
 */
public class PicketWindows implements Runnable{

    public volatile static int Max=10000;
    public volatile static int index=1;

    public volatile static int total=0;
    public static ConcurrentHashMap map= new ConcurrentHashMap();

    private String name;

    public PicketWindows(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index<=Max){
            System.out.println(this.name+"出票口排队"+(index++)+"号顾客");
            map.put(index,index);
        }
    }
}
