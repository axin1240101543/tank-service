package com.darren.center.designpatterns.singleton;

/**
 * <h3>tank-service</h3>
 * <p>单例7</p>
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 * @author : Darren
 * @date : 2020年07月23日 14:57:04
 **/
public class Singleton_007 {

    private Singleton_007() {
    }

    private static class SingletonHolder{
        private static final Singleton_007 INSTANCE = new Singleton_007();
    }

    public static Singleton_007 getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
