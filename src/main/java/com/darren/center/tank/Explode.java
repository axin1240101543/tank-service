package com.darren.center.tank;

import java.awt.*;

/**
 * <h3>tank-service</h3>
 * <p>爆炸类</p>
 *
 * @author : Darren
 * @date : 2020年07月22日 09:23:33
 **/
public class Explode extends GameObject{

    //坐标
    private int x, y;
    //大小
    public static int WIDTH = ResourceMgr.getInstance().explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.getInstance().explodes[0].getHeight();

    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;

        new Thread(()->new Audio("audio/explode.wav").play()).start();

        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.getInstance().explodes[step++], x, y , null);
        if (step >= ResourceMgr.getInstance().explodes.length)
            GameModel.getInstance().remove(this);
    }
}
