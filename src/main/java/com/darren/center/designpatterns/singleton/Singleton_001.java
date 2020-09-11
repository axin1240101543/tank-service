package com.darren.center.designpatterns.singleton;

/**
 * <h3>tank-service</h3>
 * <p>单例1</p>
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时就实例化
 * Class.forName("");
 * 话说你不用的，你装载它干啥
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
