package com.darren.center.DesignPatterns.Factory.AbstractFactory;


/**
 * <h3>tank-service</h3>
 * <p>主类</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 16:39:35
 **/
public class Main {

    public static void main(String[] args) {
        Car c = new Car();
        c.go();
        Ak47 ak47 = new Ak47();
        ak47.shoot();
        Bread bread = new Bread();
        bread.eat();

        Broom broom = new Broom();
        broom.go();
        MagicStick magicStick = new MagicStick();
        magicStick.shoot();
        MushRoom mushRoom = new MushRoom();
        mushRoom.eat();
        //需求：可以扩展产品一族？

    }

}
