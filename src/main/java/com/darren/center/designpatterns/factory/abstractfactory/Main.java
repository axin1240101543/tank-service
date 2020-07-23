package com.darren.center.designpatterns.factory.abstractfactory;


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
        AbstractFactory factory = new ModernFactory();

        Food food = factory.createFood();
        food.eat();
        Vehicle vehicle = factory.createVehicle();
        vehicle.go();
        Weapon weapon = factory.createWeapon();
        weapon.shoot();

        AbstractFactory factory1 = new MagicFactory();

        Food food1 = factory1.createFood();
        food1.eat();
        Vehicle vehicle1 = factory1.createVehicle();
        vehicle1.go();
        Weapon weapon1 = factory1.createWeapon();
        weapon1.shoot();

        //为什么抽象的食物、武器、车辆不使用接口？可移动的为什么使用接口？
        //这是语义的问题，食物只的是某一大类，并不是只具体的食物，
        //而可移动的是某个具体的东西的属性，使用接口比较合适。还有可吃的、可玩的之类的。
        //形容词用接口，名词用抽象类。

        /**
         * 工厂方法扩展某一类产品比较合适（产品维度扩展）；
         * 抽象工厂扩展某一族产品比较合适（产品一族进行扩展）；
         * 两种模式都有各自的局限性
         *
         * 有什么方式可以结合两者的优点呢？
         * spring IOC
         *
         *
         * 抽象工厂怎么应用到tank-service？
         * 坦克 + 子弹 + 爆炸
         *
         * 类似换皮肤
         */
    }

}
