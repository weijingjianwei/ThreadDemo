package com.example.Singleton;

/**
 * 描述:
 * 内部类写法
 *
 * @author hongjw
 * @create 2020-01-05 14:14
 */
public class Sinleton3 {

    private Sinleton3(){

    }

    private static class InnerSingleton{
        private final static  Sinleton3 sinleton3 = new Sinleton3();
    }


    public Sinleton3 getinstance(){
        return InnerSingleton.sinleton3;
    }
}
