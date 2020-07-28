package com.darren.center.designpatterns.proxy.v3;

import java.util.Random;

/**
 * <h3>tank-service</h3>
 * 解决问题：如果无法修改方法源码呢？  benchmark<
 * 用继承?
 *
 * 新问题：耦合度太高
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
        new Tank2().move();
    }
}

class Tank2 extends Tank{

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

interface Movable{
    void move();
}
