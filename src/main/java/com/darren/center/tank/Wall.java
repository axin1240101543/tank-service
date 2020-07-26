package com.darren.center.tank;

import java.awt.*;

/**
 * <h3>tank-service</h3>
 * <p>障碍物墙</p>
 *
 * @author : Darren
 * @date : 2020年07月26日 14:38:00
 **/
public class Wall extends GameObject{

    int w, h;

    public Rectangle  rect;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rect = new Rectangle(x, y, w, h);
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, w, h);
        g.setColor(color);
    }

    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }
}
