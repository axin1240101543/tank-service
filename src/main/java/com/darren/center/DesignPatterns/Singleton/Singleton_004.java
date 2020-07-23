package com.darren.center.DesignPatterns.Singleton;

/**
 * <h3>tank-service</h3>
 * <p>单例4</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 14:57:04
 **/
public class Singleton_004 {

    private static Singleton_004 INSTANCE;

    private Singleton_004() {
    }

    public static synchronized Singleton_004 getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Singleton_004();
        }
        return INSTANCE;
    }
}
