package com.example.objectAndListener;

/**
 * 描述:
 * obj runable抽象类
 *
 * @author hongjw
 * @create 2020-01-08 9:30
 */
public abstract class ObjAbstractRunable implements Runnable {

    private  ListenerObserver listenerObserver;

    @Override
    public void run() {

        try {
            notifyAllListen(new InnerObjRunableState(RunableState.RUNABLE,null,null));
        }catch (Exception e){
            notifyAllListen(new InnerObjRunableState(RunableState.EXCEPTION,null,e));
        }finally {
            notifyAllListen(new InnerObjRunableState(RunableState.DEAD,null,null));
        }
    }

    public ObjAbstractRunable(ListenerObserver listenerObserver) {
        this.listenerObserver=listenerObserver;
    }

    public class InnerObjRunableState{
        private RunableState runableState;
        private Thread thread;
        private Throwable throwable;

        public InnerObjRunableState(RunableState runableState, Thread thread, Throwable throwable) {
            this.runableState = runableState;
            this.thread = thread;
            this.throwable = throwable;
        }

        public RunableState getRunableState() {
            return runableState;
        }

        public void setRunableState(RunableState runableState) {
            this.runableState = runableState;
        }

        public Thread getThread() {
            return thread;
        }

        public void setThread(Thread thread) {
            this.thread = thread;
        }

        public Throwable getThrowable() {
            return throwable;
        }

        public void setThrowable(Throwable throwable) {
            this.throwable = throwable;
        }
    }

    public  void notifyAllListen(InnerObjRunableState innerObjRunableState){
        listenerObserver.reviceNotice(innerObjRunableState);
    }
}
