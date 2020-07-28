package com.darren.center.designpatterns.proxy.v4;

import java.util.Random;

/**
 * <h3>tank-service</h3>
 * 解决问题：v3耦合度太高
 * 使用代理
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
    }
}

/**
 * 使用代理类，将被代理类聚合进来
 */
class TankTimeProxy implements Movable{

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

interface Movable{
    void move();
}
