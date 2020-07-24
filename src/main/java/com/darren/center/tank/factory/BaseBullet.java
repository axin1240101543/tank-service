package com.darren.center.tank.factory;

import com.darren.center.tank.Tank;

import java.awt.*;

/**
 * <h3>tank-service</h3>
 * <p>子弹抽象工厂</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 22:34:35
 **/
public abstract class BaseBullet {

    public abstract void paint(Graphics g);

    public abstract void collideWith(Tank tank);
}

