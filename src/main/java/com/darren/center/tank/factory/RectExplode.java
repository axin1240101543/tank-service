package com.darren.center.tank.factory;

import com.darren.center.tank.Audio;
import com.darren.center.tank.ResourceMgr;
import com.darren.center.tank.TankFrame;

import java.awt.*;

/**
 * <h3>tank-service</h3>
 * <p>方形爆炸</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 22:58:55
 **/
public class RectExplode extends BaseExplode{

    //坐标
    private int x, y;
    //大小
    public static int WIDTH = ResourceMgr.getInstance().explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.getInstance().explodes[0].getHeight();

    private TankFrame tankFrame;
    private boolean living = true;

    private int step = 0;

    public RectExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;

        //new Audio("audio/explode.wav").start();
        new Thread(()->new Audio("audio/explode.wav").play()).start();
    }

    @Override
    public void paint(Graphics g) {
        //g.drawImage(ResourceMgr.getInstance().explodes[step++], x, y , tankFrame);

        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10*step, 10*step);
        step++;

        if (step >= 10)
            tankFrame.explodes.remove(this);

        g.setColor(color);
    }

}

