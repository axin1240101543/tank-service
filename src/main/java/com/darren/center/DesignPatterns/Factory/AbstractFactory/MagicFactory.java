package com.darren.center.DesignPatterns.Factory.AbstractFactory;

/**
 * <h3>tank-service</h3>
 * <p>魔法世界工厂</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 20:40:38
 **/
public class MagicFactory extends AbstractFactory{

    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }
}
