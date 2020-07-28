package com.darren.center.designpatterns.proxy.v7;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * <h3>tank-service</h3>
 * 如果有stop方法需要代理...
 * 如果想让LogProxy可以重用，不仅可以代理Tank，还可以代理任何其他可以代理的类型 Object
 * （毕竟日志记录，时间计算是很多方法都需要的东西），这时该怎么做呢？
 * 分离代理行为与被代理对象
 * v7：使用jdk的动态代理
 *
 * @author : Darren
 * @date : 2020年07月28日 11:16:00
 **/
public class Tank implements Movable {

    /**
     * 模拟tank移动了一会儿
     */
    @Override
    public void move() {
        System.out.println("tank moving ……");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();

        //类加载器  代理对象应该实现的接口 实现了invocationHandler的对象
        Movable movable = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new LogHandler(tank)
        );
        movable.move();
    }
}

class LogHandler implements InvocationHandler {

    Tank tank;

    public LogHandler(Tank tank) {
        this.tank = tank;
    }

    /**
     *
     * @param proxy 代理对象
     * @param method 哪个方法
     * @param args 方法需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start moving……");
        Object obj = method.invoke(tank, args);
        System.out.println("start stopped!!!");
        return obj;
    }
}

interface Movable{
    void move();
}
