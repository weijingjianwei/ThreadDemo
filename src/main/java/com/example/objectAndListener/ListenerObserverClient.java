package com.example.objectAndListener;

import java.util.stream.IntStream;

/**
 * 描述:
 * jiantin
 *
 * @author hongjw
 * @create 2020-01-08 10:46
 */
public class ListenerObserverClient {
    public static void main(String[] args) {
        ListenerObserver listenObserver = new ListenObserverImpl();
        IntStream.rangeClosed(1,10).forEach(index->{
            new Thread(new ObjAbstractRunable(listenObserver) {
            },index+"").start();
        });
    }
}
