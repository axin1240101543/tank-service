package com.darren.center.designpatterns.singleton;

/**
 * <h3>tank-service</h3>
 * <p>单例5</p>
 * 不是线程安全的，因为if和synchronized不是原子性操作，线程a进入了if，线程b也进入了if，
 * 结果线程b先抢到了这把锁先创建了对象并释放，然后线程a继续执行，然后又创建了一个对象。
 * @author : Darren
 * @date : 2020年07月23日 14:57:04
 **/
public class Singleton_005 {

    private static Singleton_005 INSTANCE;

    private Singleton_005() {
    }

    public static Singleton_005 getInstance(){
        if (INSTANCE == null){
            synchronized (Singleton_005.class){
                INSTANCE = new Singleton_005();
            }
        }
        return INSTANCE;
    }
}
