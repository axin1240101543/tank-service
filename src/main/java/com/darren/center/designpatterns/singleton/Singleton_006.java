package com.darren.center.designpatterns.singleton;

/**
 * <h3>tank-service</h3>
 * <p>单例6</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 14:57:04
 **/
public class Singleton_006 {

    private static volatile Singleton_006 INSTANCE;

    private Singleton_006() {
    }

    public static synchronized Singleton_006 getInstance(){
        if (INSTANCE == null){
            synchronized (Singleton_006.class){
                if (INSTANCE == null){
                    INSTANCE = new Singleton_006();
                }
            }
        }
        return INSTANCE;
    }
}
