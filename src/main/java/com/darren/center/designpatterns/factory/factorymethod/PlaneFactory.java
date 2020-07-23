package com.darren.center.designpatterns.factory.factorymethod;

import com.darren.center.designpatterns.factory.Plane;
import com.darren.center.designpatterns.factory.Removeable;

/**
 * <h3>tank-service</h3>
 * <p>飞机工厂</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 16:53:57
 **/
public class PlaneFactory {

    public static Removeable create(){
        return new Plane();
    }

}
