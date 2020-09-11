package com.darren.center.designpatterns.singleton;

/**
 * <h3>tank-service</h3>
 * <p>单例4</p>
 * 在static getInstance方法上加synchronized，给.class加锁
 * 虽然达到了按需初始化的目的，但却带来了线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降。
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
