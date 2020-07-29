package com.darren.center.designpatterns.proxy.spring.v1;

import java.util.Random;

/**
 * <h3>tank-service</h3>
 * <p>被代理类</p>
 *
 * @author : Darren
 * @date : 2020年07月28日 15:00:18
 **/
public class Tank {

    public void move() {
        System.out.println("tank moving ……");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
