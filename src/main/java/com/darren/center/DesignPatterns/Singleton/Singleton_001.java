package com.darren.center.DesignPatterns.Singleton;

/**
 * <h3>tank-service</h3>
 * <p>单例1</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 14:57:04
 **/
public class Singleton_001 {

    private static final Singleton_001 INSTANCE = new Singleton_001();

    private Singleton_001() {
    }

    public static Singleton_001 getInstance(){
        return INSTANCE;
    }
}
