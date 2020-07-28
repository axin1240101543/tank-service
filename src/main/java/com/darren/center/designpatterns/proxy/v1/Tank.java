package com.darren.center.designpatterns.proxy.v1;

import java.util.Random;

/**
 * <h3>tank-service</h3>
 * 问题：想记录坦克的移动时间
 * @author : Darren
 * @date : 2020年07月28日 11:13:30
 **/
public class Tank implements Movable{

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
}

interface Movable{
    void move();
}
