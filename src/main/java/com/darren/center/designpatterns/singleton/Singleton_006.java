package com.darren.center.designpatterns.singleton;

/**
 * <h3>tank-service</h3>
 * <p>单例6</p>
 * 双重检查单例
 * 第一次检查是否还需要？
 * 能省事儿，大多数线程在第一次进来之后就不会往下执行了。
 *
 * 需要加上volatile，防止指令重排。申请内存 -> 初始化 -> 指向新的内存地址
 * @author : Darren
 * @date : 2020年07月23日 14:57:04
 **/
public class Singleton_006 {

    private static volatile Singleton_006 INSTANCE;

    private Singleton_006() {
    }

    public static Singleton_006 getInstance(){
        // 尽量避免重复进入同步块
        if (INSTANCE == null){
            // 同步.class，意味着对同步类方法调用
            synchronized (Singleton_006.class){
                if (INSTANCE == null){
                    INSTANCE = new Singleton_006();
                }
            }
        }
        return INSTANCE;
    }
}
