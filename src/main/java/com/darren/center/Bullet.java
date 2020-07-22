package com.darren.center;

import java.awt.*;

/**
 * <h3>tank-service</h3>
 * <p>子弹</p>
 *
 * @author : Darren
 * @date : 2020年07月22日 09:23:33
 **/
public class Bullet {

    //坐标
    private int x, y;
    //方向
    private Dir dir;
    //速度
    private static final int SPEED = 1;
    //大小
    private int width = 30, height=30;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, width, height);
        g.setColor(color);
        move();
    }

    private void move() {
        //根据按键的方向移动
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
    }

}
