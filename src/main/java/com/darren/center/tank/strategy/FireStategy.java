package com.darren.center.tank.strategy;

import com.darren.center.tank.Tank;

import java.io.Serializable;

public interface FireStategy extends Serializable {

    void fire(Tank tank);

}
