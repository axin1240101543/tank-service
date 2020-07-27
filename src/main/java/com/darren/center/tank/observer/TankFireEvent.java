package com.darren.center.tank.observer;

import com.darren.center.tank.Tank;

/**
 * <h3>tank-service</h3>
 * <p>tank开火事件</p>
 *
 * @author : Darren
 * @date : 2020年07月27日 12:08:07
 **/
public class TankFireEvent {

    Tank tank;

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }

    public Tank getSource(){
        return tank;
    }
}
