package com.example.ReadAndWriteSeparate;

/**
 * 描述:
 * main
 *
 * @author hongjw
 * @create 2020-01-09 17:10
 */
public class ReadAndWriteClient {
    private static final ReadAndWriteLock readAndWriteLock=new ReadAndWriteLock();
    public static void main(String[] args) {
        CommonData commonData = new CommonData(5);

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        new readThread(readAndWriteLock,commonData).start();
//        new readThread(readAndWriteLock,commonData).start();
        new readThread(readAndWriteLock,commonData).start();


//        new WriteThread(readAndWriteLock,commonData).start();
        new WriteThread(readAndWriteLock,commonData).start();
//        WriteThread writeThread = new WriteThread(readAndWriteLock, commonData);
//
//        readThread readThread = new readThread(readAndWriteLock, commonData);
//        System.out.println(writeThread.getReadAndWriteLock()==readThread.getReadAndWriteLock());
    }
}
