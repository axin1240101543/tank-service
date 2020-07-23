package com.darren.center.DesignPatterns.Singleton;

/**
 * <h3>tank-service</h3>
 * <p>单例7</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 14:57:04
 **/
public class Singleton_007 {

    private Singleton_007() {
    }

    private static class SingletonHolder{
        private static final Singleton_007 INSTANCE = new Singleton_007();
    }

    public static synchronized Singleton_007 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
