package com.darren.center.DesignPatterns.Factory.FactoryMethod;

import com.darren.center.DesignPatterns.Factory.Car;
import com.darren.center.DesignPatterns.Factory.Removeable;

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
