package com.darren.center.DesignPatterns.Factory.FactoryMethod;

import com.darren.center.DesignPatterns.Factory.Broom;
import com.darren.center.DesignPatterns.Factory.Removeable;

/**
 * <h3>tank-service</h3>
 * <p>扫帚工厂</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 16:54:13
 **/
public class BroomFactory {

    public static Removeable create(){
        return new Broom();
    }

}
