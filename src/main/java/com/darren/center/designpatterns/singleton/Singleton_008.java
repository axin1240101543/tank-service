package com.darren.center.designpatterns.singleton;

/**
 * <h3>tank-service</h3>
 * <p>单例8</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 14:57:04
 **/
public enum  Singleton_008 {

    INSTANCE;

    public static synchronized Singleton_008 getInstance(){
        return Singleton_008.INSTANCE;
    }
}
