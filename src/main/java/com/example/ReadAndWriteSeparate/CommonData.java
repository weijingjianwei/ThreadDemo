package com.example.ReadAndWriteSeparate;

/**
 * 描述:
 * 共享数据
 *
 * @author hongjw
 * @create 2020-01-09 17:00
 */
public class CommonData {
    private volatile char[] datachars;

    public CommonData(int size){
        datachars= new char[size];
    }


    public char[] getDataChar(){
        return datachars;
    }

    public char[] setDataChar(char c){
        for (int i = 0; i < datachars.length; i++) {
            datachars[i]=c;
        }
        return datachars;
    }
}
