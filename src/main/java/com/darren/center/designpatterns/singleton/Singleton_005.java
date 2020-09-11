package com.darren.center.designpatterns.singleton;

/**
 * <h3>tank-service</h3>
 * <p>单例5</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 14:57:04
 **/
public class Singleton_005 {

    private static Singleton_005 INSTANCE;

    private Singleton_005() {
    }

    public static Singleton_005 getInstance(){
        if (INSTANCE == null){
            synchronized (Singleton_005.class){
                INSTANCE = new Singleton_005();
            }
        }
        return INSTANCE;
    }
}
