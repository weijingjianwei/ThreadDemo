package com.example.Volatitle;

/**
 * 描述:
 * game
 *
 * @author hongjw
 * @create 2020-01-07 20:05
 */
public class Game extends Thread{
    public volatile User user=new User("tom");

    @Override
    public void run() {
        System.out.println("Game Start");
        while (true) {
            if (!user.getName().equals("tom")) {
                break;
            }
        }
        System.out.println("Game End");
    }
}
