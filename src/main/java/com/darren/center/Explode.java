package com.darren.center;

import java.awt.*;

/**
 * <h3>tank-service</h3>
 * <p>爆炸类</p>
 *
 * @author : Darren
 * @date : 2020年07月22日 09:23:33
 **/
public class Explode {

    //坐标
    private int x, y;
    //大小
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private TankFrame tankFrame;
    private boolean living = true;

    private int step = 0;

    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;

        //new Audio("audio/explode.wav").start();
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y , tankFrame);
        if (step >= ResourceMgr.explodes.length) step = 0;
    }
}
