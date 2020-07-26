package com.darren.center.tank.decorator;

import com.darren.center.tank.GameObject;

import java.awt.*;

/**
 * <h3>tank-service</h3>
 * <p>装饰器模式</p>
 *
 * @author : Darren
 * @date : 2020年07月26日 19:31:57
 **/
public abstract class GODecorator extends GameObject {

    GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);
}
