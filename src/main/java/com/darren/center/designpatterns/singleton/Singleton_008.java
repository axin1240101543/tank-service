package com.darren.center.designpatterns.singleton;

/**
 * <h3>tank-service</h3>
 * <p>单例8</p>
 * 不仅可以解决线程同步，还可以防止反序列化。（effective java）
 * 枚举类不会反序列化的原因是枚举类没有构造方法。
 *
 * 在单例中为什么要防止序列化反序列化？
 * java的反射可以通过class文件加载到内存，然后创建一个实例。
 *
 * @author : Darren
 * @date : 2020年07月23日 14:57:04
 **/
public enum  Singleton_008 {

    INSTANCE;

    public static Singleton_008 getInstance(){
        return Singleton_008.INSTANCE;
    }
}
