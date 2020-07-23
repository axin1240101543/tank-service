package com.darren.center.designpatterns.singleton;

/**
 * <h3>tank-service</h3>
 * <p>单例3</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 14:57:04
 **/
public class Singleton_003 {

    private static Singleton_003 INSTANCE;

    private Singleton_003() {
    }

    public static Singleton_003 getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Singleton_003();
        }
        return INSTANCE;
    }
}
