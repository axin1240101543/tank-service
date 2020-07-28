package com.darren.center.designpatterns.proxy.v6;

import java.util.Random;

/**
 * <h3>tank-service</h3>
 * <p>解决问题：如何实现代理的各种组合？继承？Decorator?</p>
 *
 * v6：代理的对象改成Movable类型-越来越像decorator了
 *
 * 静态代理
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
        /*new TankTimeProxy(new Tank()).move();
        new TankLogProxy(new Tank()).move();*/
        new TankLogProxy(new TankTimeProxy(new Tank())).move();
    }
}

/**
 * 使用tank移动时间代理类，将被代理类聚合进来
 */
class TankTimeProxy implements Movable {

    Movable movable;

    public TankTimeProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        movable.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

/**
 * 使用tank日志代理类，将被代理类聚合进来
 */
class TankLogProxy implements Movable {

    Movable movable;

    public TankLogProxy(Movable movable) {
        this.movable = movable;
    }

    @Override
    public void move() {
        System.out.println("start moving……");
        movable.move();
        System.out.println("start stopped!!!");
    }
}

interface Movable{
    void move();
}
