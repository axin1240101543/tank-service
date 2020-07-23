package com.darren.center.designpatterns.factory.abstractfactory;

/**
 * <h3>tank-service</h3>
 * <p>魔法棒</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 17:10:23
 **/
public class MagicStick extends Weapon{

    @Override
    public void shoot(){
        System.out.println("MagicStick shoot …………");
    }

}
