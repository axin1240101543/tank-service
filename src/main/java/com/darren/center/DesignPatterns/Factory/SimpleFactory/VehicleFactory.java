package com.darren.center.DesignPatterns.Factory.SimpleFactory;

import com.darren.center.DesignPatterns.Factory.Broom;
import com.darren.center.DesignPatterns.Factory.Car;
import com.darren.center.DesignPatterns.Factory.Plane;
import com.darren.center.DesignPatterns.Factory.Removeable;

/**
 * <h3>tank-service</h3>
 * <p>简单工厂</p>
 *
 * 扩展性不好
 *
 * @author : Darren
 * @date : 2020年07月23日 16:50:07
 **/
public class VehicleFactory {

    public static Removeable createCar(){
        //before processing
        //权限控制
        return new Car();
    }

    public static Removeable createPlane(){
        return new Plane();
    }

    public static Removeable createBroom(){
        return new Broom();
    }

}
