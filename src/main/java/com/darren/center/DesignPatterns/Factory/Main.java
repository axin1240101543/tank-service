package com.darren.center.DesignPatterns.Factory;

import com.darren.center.DesignPatterns.Factory.FactoryMethod.BroomFactory;
import com.darren.center.DesignPatterns.Factory.FactoryMethod.CarFactory;
import com.darren.center.DesignPatterns.Factory.FactoryMethod.PlaneFactory;
import com.darren.center.DesignPatterns.Factory.SimpleFactory.VehicleFactory;

/**
 * <h3>tank-service</h3>
 * <p>主类</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 16:39:35
 **/
public class Main {

    public static void main(String[] args) {
        /*Car c = new Car();
        c.go();*/

        /*Plane p = new Plane();
        p.go();*/

        //任意定制交通工具，多态的运用
        //继承Removeable
        Removeable car1 = new Car();
        car1.go();
        Removeable plane1 = new Plane();
        plane1.go();
        Removeable broom1 = new Broom();
        broom1.go();

        //任意定制生产过程 Removeable XXXFactory.create()
        //简单工厂 VehicleFactory
        Removeable car2 = VehicleFactory.createCar();
        car2.go();
        Removeable plane2 = VehicleFactory.createPlane();
        plane2.go();
        Removeable broom2 = VehicleFactory.createBroom();
        broom2.go();

        //任意定制生产过程 Removeable XXXFactory.create()
        //工厂方法 CarFactory PlaneFactory BroomFactory
        Removeable car3 = CarFactory.create();
        car3.go();
        Removeable plane3 = PlaneFactory.create();
        plane3.go();
        Removeable broom3 = BroomFactory.create();
        broom3.go();

        //任意定制产品一族
        //抽象工厂
        //com.darren.center.DesignPatterns.Factory.AbstractFactory.Main


    }

}
