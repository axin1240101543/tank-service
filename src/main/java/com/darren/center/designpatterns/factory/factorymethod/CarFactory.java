package com.darren.center.designpatterns.factory.factorymethod;

import com.darren.center.designpatterns.factory.Car;
import com.darren.center.designpatterns.factory.Removeable;

/**
 * <h3>tank-service</h3>
 * <p>小车工厂</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 16:53:00
 **/
public class CarFactory {

    public static Removeable create(){
        //before processing
        //权限控制
        return new Car();
    }

}
