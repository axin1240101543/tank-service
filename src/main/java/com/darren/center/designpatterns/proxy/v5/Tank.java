package com.darren.center.designpatterns.proxy.v5;

import java.util.Random;

/**
 * v5:代理有各种类型
 * 新问题：如何实现代理的各种组合？继承？Decorator?
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
        new TankTimeProxy(new Tank()).move();
        new TankLogProxy(new Tank()).move();
    }
}

/**
 * 使用tank移动时间代理类，将被代理类聚合进来
 */
class TankTimeProxy implements Movable {

    Tank tank;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        tank.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

/**
 * 使用tank日志代理类，将被代理类聚合进来
 */
class TankLogProxy implements Movable {

    Tank tank;

    public TankLogProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        System.out.println("start moving……");
        tank.move();
        System.out.println("start stopped!!!");
    }
}

interface Movable{
    void move();
}
