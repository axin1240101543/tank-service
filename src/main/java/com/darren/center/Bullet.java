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
    private static final int SPEED = 6;
    //大小
    public static int WIDTH = ResourceMgr.bulletU.getWidth();
    public static int HEIGHT = ResourceMgr.bulletU.getHeight();

    private TankFrame tankFrame;
    //因为子弹没有删除，会发生内存泄露，所以要判断子弹超出windows就删除子弹
    private boolean living = true;
    //将我方坦克子弹和敌方坦克子弹进行区分
    private Group group = Group.BAD;

    public Bullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        if (!living) tankFrame.bullets.remove(this);
        /*Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);*/
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }
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

        if (x < 0 || y < 0 || x > tankFrame.GAME_WIDTH || y > tankFrame.GAME_HEIGHT) living = false;
    }

    public void collideWith(Tank tank) {
        //自己不伤害自己
        if (this.group == tank.getGroup()) return;

        //TODO：用一个rectangle来记录子弹的位置
        Rectangle rBullet = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle rTank = new Rectangle(tank.getX(), tank.getY(), Tank.WIDTH, Tank.HEIGHT);
        if (rBullet.intersects(rTank)){
            tank.die();
            this.die();
        }
    }

    private void die() {
        living = false;
    }
}
