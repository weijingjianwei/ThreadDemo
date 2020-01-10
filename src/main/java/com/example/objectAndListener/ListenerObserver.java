package com.example.objectAndListener;

/**
 * 描述:
 * 观察者
 *
 * @author hongjw
 * @create 2020-01-08 9:33
 */
public interface ListenerObserver {

    Object lockobj=new Object();
    void reviceNotice(ObjAbstractRunable.InnerObjRunableState innerObjRunableState);
}
