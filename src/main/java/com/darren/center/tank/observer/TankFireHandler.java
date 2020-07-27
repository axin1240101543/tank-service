package com.darren.center.tank.observer;

import com.darren.center.tank.Tank;

/**
 * <h3>tank-service</h3>
 * <p>坦克开火处理器</p>
 *
 * @author : Darren
 * @date : 2020年07月27日 12:09:27
 **/
public class TankFireHandler implements TankFireObserver{

    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank source = e.getSource();
        source.fire();
    }
}
