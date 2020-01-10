package com.example.Singleton;

/**
 * 描述:
 * 单例模式1 (恶汉模式)
 *
 * @author hongjw
 * @create 2020-01-05 14:04
 */
public class Singleton1 {

    private static final Singleton1 singleton_1 = new Singleton1();

    private Singleton1(){

    }

    public Singleton1 getinstance(){
        return singleton_1;
    }
}
