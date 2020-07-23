package com.darren.center.DesignPatterns.Singleton;

/**
 * <h3>tank-service</h3>
 * <p>单例3</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 14:57:04
 **/
public class Singleton_002 {

    private static final Singleton_002 INSTANCE;

    static{
        INSTANCE = new Singleton_002();
    }

    private Singleton_002() {
    }

    public static Singleton_002 getInstance(){
        return INSTANCE;
    }
}
