package com.darren.center.tank.observer;

import java.io.Serializable;

/**
 * 观察者
 */
public interface TankFireObserver extends Serializable {

    void actionOnFire(TankFireEvent e);

}
