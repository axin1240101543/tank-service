package com.darren.center.designpatterns.factory.simplefactory;

import com.darren.center.designpatterns.factory.Broom;
import com.darren.center.designpatterns.factory.Car;
import com.darren.center.designpatterns.factory.Plane;
import com.darren.center.designpatterns.factory.Removeable;

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
