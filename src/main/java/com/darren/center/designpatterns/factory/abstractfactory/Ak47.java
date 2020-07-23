package com.darren.center.designpatterns.factory.abstractfactory;

/**
 * <h3>tank-service</h3>
 * <p>步枪</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 17:06:22
 **/
public class Ak47 extends Weapon{

    @Override
    public void shoot(){
        System.out.println("Ak47 shoot …………");
    }

}
