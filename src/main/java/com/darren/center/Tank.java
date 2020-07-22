package com.darren.center;

import java.awt.*;

/**
 * <h3>tank-service</h3>
 * <p>坦克</p>
 *
 * @author : Darren
 * @date : 2020年07月22日 08:56:52
 **/
public class Tank {

    //坐标
    private int x = 200, y = 200;
    //方向
    private Dir dir = Dir.DOWN;
    //速度
    private static final int SPEED = 5;
    //是否移动
    private boolean moving = false;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x, y,50,50);
        g.setColor(color);
        move();
    }

    private void move() {
        //如果moving是false那么就静止
        if (!moving) return;
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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }
}
