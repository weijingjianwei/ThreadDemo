package com.example.objectAndListener;

/**
 * 描述:
 * 观察者实现者
 *
 * @author hongjw
 * @create 2020-01-08 9:43
 */
public class ListenObserverImpl implements ListenerObserver{


    @Override
    public void reviceNotice(ObjAbstractRunable.InnerObjRunableState innerObjRunableState) {
        synchronized (lockobj){
            if(innerObjRunableState.getThrowable()!=null){
                System.out.println(Thread.currentThread().getName()+"出现异常"+innerObjRunableState.getThrowable().getLocalizedMessage());
            }
            System.out.println(Thread.currentThread().getName()+innerObjRunableState.getRunableState());
        }
    }
}
