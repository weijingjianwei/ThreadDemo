package com.example.Volatitle;

/**
 * 描述:
 * VolatileTest
 *
 * @author hongjw
 * @create 2020-01-07 19:54
 */
public class VolatileTest {
    public static void main(String[] args) throws InterruptedException {
//        MyTask task = new MyTask();
//        new Thread(task).start();
//
//        while (true){
//            //读取值
//            //直接用线程缓存的值 不会去主内存去拉取变量
//            if (task.isFlag()){
////                System.out.println("=============");
////                break;
//            }
//
//            /*
//           synchronized (task){
//                if (task.isFlag()){
//                    System.out.println("=============");
//                    break;
//                }
//            }*/
//
//        }


            Game game = new Game();
            game.start();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {

            }
            game.user.setName("aaaaa");;
            System.out.println("change.....");

    }
}
