
package com.example.Volatitle;



/**
 * 描述:
 * 验证多线程下出现的数据不可见
 *
 * @author hongjw
 * @create 2019-01-07 16:52
 */
public class Voliatitle1 {
    private static int index=0;
    private final static int max=1000;

    public static void main(String[] args) throws InterruptedException {


        new Thread(()->{
            int num=index;
            while (index<max){
                if(num!=index){
                    System.out.println("read index "+index);
                }
            }
        }).start();

        Thread.sleep(10);

        new Thread(()->{
            while (index<max){
                System.out.println("update index "+index++);
            }
        }).start();
    }

}
