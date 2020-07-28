package com.darren.center.designpatterns.proxy.v2;

import java.util.Random;

/**
 * <h3>tank-service</h3>
 * 解决问题：想记录坦克的移动时间
 * 修改代码，记录时间
 *
 * 新问题：如果无法修改方法源码呢？  benchmark
 * @author : Darren
 * @date : 2020年07月28日 11:16:00
 **/
public class Tank implements Movable {

    /**
     * 模拟tank移动了一会儿
     */
    @Override
    public void move() {
        long start = System.currentTimeMillis();

        System.out.println("tank moving ……");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}

interface Movable{
    void move();
}
