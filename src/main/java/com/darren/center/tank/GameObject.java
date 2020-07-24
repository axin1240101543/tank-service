package com.darren.center.tank;

import java.awt.*;

/**
 * <h3>tank-service</h3>
 * <p>游戏物品父类</p>
 *
 * @author : Darren
 * @date : 2020年07月24日 16:17:15
 **/
public abstract class GameObject {

    //坐标
    public int x = 200, y = 200;


    public abstract void paint(Graphics g);

}
