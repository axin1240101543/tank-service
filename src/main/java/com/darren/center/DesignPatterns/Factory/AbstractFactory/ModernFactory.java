package com.darren.center.DesignPatterns.Factory.AbstractFactory;

/**
 * <h3>tank-service</h3>
 * <p>现代世界工厂</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 20:40:38
 **/
public class ModernFactory extends AbstractFactory{

    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }

    @Override
    Weapon createWeapon() {
        return new Ak47();
    }
}
