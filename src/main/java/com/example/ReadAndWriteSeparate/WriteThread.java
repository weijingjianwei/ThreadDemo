package com.example.ReadAndWriteSeparate;

import java.util.Arrays;
import java.util.UUID;

/**
 * 描述:
 * 写线程
 *
 * @author hongjw
 * @create 2020-01-09 16:58
 */
public class WriteThread extends Thread{
    private ReadAndWriteLock readAndWriteLock;
    private CommonData commonData;

    public WriteThread(ReadAndWriteLock readAndWriteLock,CommonData commonData) {
        this.readAndWriteLock=readAndWriteLock;
        this.commonData=commonData;
    }

    public ReadAndWriteLock getReadAndWriteLock() {
        return readAndWriteLock;
    }

    public void setReadAndWriteLock(ReadAndWriteLock readAndWriteLock) {
        this.readAndWriteLock = readAndWriteLock;
    }

    public CommonData getCommonData() {
        return commonData;
    }

    public void setCommonData(CommonData commonData) {
        this.commonData = commonData;
    }

    @Override
    public void run() {
        while (true){
            readAndWriteLock.writelock();
            char[] chars = commonData.setDataChar(UUID.randomUUID().toString().charAt(0));
            System.out.println(Thread.currentThread().getName()+"-write-"+ Arrays.toString(chars));
            readAndWriteLock.unwritelock();
        }
    }
}
