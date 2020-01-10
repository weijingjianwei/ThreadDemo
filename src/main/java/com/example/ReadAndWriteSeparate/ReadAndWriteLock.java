package com.example.ReadAndWriteSeparate;

/**
 * 描述:
 *
 * @author hongjw
 * @create 2020-01-09 16:43
 */
public class ReadAndWriteLock {
    private int reading_person;
    private int waitreading_person;
    private int writeing_person;
    private int waitwriteing_person;

    public void readblock(){
        synchronized (this){
            waitreading_person++;
            while (writeing_person>0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    waitreading_person--;
                }
            }
            reading_person++;
        }
    }

    public void unreadlock(){
        synchronized (this){
            this.reading_person--;
            this.notifyAll();
        }
    }

    public void writelock(){
        synchronized (this){
            waitwriteing_person++;
            while (writeing_person>0||reading_person>0){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    waitwriteing_person--;
                }
            }
            writeing_person++;
        }
    }

    public void unwritelock(){
        synchronized (this){
            this.writeing_person--;
            this.notifyAll();
        }
    }
}
