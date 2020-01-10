package com.example.Singleton;

/**
 * 描述:
 * 单例模式1 (懒汉模式)
 *
 * @author hongjw
 * @create 2020-01-05 14:04
 */
public class Singleton2 {

    private static Singleton2 Singleton2;

    private Singleton2(){

    }


//    //线程不安全
//    public Singleton2 getinstance(){
//        Singleton2  = new Singleton2();
//        return Singleton2;
//    }

//    //线程安全消耗资源
//
//    public  synchronized Singleton2 getSingleton2(){
//        Singleton2 = new Singleton2();
//        return Singleton2;
//    }

//    //线程安全存在重排序隐患
//    public static Singleton2 getSingleton2(){
//        if(Singleton2==null){
//            synchronized (Singleton2.class){
//                 if(Singleton2==null) Singleton2=new Singleton2();
//            }
//        }
//        return Singleton2;
//    }
}
