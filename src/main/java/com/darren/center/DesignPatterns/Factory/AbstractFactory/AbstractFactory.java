package com.darren.center.DesignPatterns.Factory.AbstractFactory;

/**
 * <h3>tank-service</h3>
 * <p>抽象工厂</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 17:20:11
 **/
public abstract class AbstractFactory {

    abstract Food createFood();

    abstract Vehicle createVehicle();

    abstract Weapon createWeapon();

}
