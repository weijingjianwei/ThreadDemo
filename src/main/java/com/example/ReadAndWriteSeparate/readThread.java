package com.example.ReadAndWriteSeparate;

import java.util.Arrays;

/**
 * 描述:
 * 读线程
 *
 * @author hongjw
 * @create 2020-01-09 16:54
 */
public class readThread extends Thread{

    private ReadAndWriteLock readAndWriteLock;
    private CommonData commonData;

    public readThread(ReadAndWriteLock readAndWriteLock, CommonData commonData) {
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
            readAndWriteLock.readblock();
            System.out.println(Thread.currentThread().getName()+"-reading-"+Arrays.toString(commonData.getDataChar()));
            readAndWriteLock.unreadlock();
        }
    }
}
