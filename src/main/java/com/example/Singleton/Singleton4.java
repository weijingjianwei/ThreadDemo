package com.example.Singleton;


import java.util.stream.IntStream;

/**
 * 描述:
 * 枚举写法
 *
 * @author hongjw
 * @create 2020-01-05 14:22
 */
public class Singleton4 {

    private Singleton4(){

    }

    private enum SinletonEnum{
        singleten;

        private final   Singleton4 singleten4;
        SinletonEnum(){
            singleten4=new Singleton4();
        }


    }

    public static Singleton4 getSingleten4(){
        return SinletonEnum.singleten.singleten4;
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1,1000).forEach(i->{
            System.out.println(Singleton4.getSingleten4());
        });
    }

}
