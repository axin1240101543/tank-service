package com.darren.center;

import java.awt.*;
import java.util.Random;

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
    private static final int SPEED = PropertyMgr.getInt("tankSpeed");
    //是否移动
    private boolean moving = true;
    //将子弹传给windows
    private TankFrame tankFrame = null;
    //大小
    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();
    //是否存活
    private boolean living = true;
    //随机数
    private Random random = new Random();
    //将我方坦克和敌方坦克进行区分
    private Group group = Group.BAD;

    //因为每次碰撞检测都会产生两个Rectangle对象，假如有n个子弹和m个坦克，
    // 那么产生的对象就是2*n*m，所以在坦克和子弹内部维护一个Rectangle来记录这个坦克和子弹的位置
    Rectangle rTank = new Rectangle();

    public Tank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;

        //对内部维护的Rectangle进行初始化
        this.rTank.x = this.x;
        this.rTank.y = this.y;
        this.rTank.width = WIDTH;
        this.rTank.height = HEIGHT;
    }

    public void paint(Graphics g) {
        /*Color color = g.getColor();
        g.setColor(Color.yellow);
        g.fillRect(x, y,50,50);
        g.setColor(color);*/
        //g.drawImage(ResourceMgr.tankL, x, y, null);

        //要移除list中的元素，否则会内存泄漏
        //if (!living) return;
        if (!living) tankFrame.tanks.remove(this);

        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
        }
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

        //只有敌方坦克概率随机发射子弹
        if (this.group == Group.BAD && random.nextInt(100) > 95) this.fire();
        //只有敌方坦克随机改变方向
        if (this.group == Group.BAD && random.nextInt(100) > 95) randomDir();

        //便捷检测：敌方坦克撞墙的处理
        boundsCheck();

        //对内部维护的Rectangle进行更新
        this.rTank.x = this.x;
        this.rTank.y = this.y;
    }

    private void boundsCheck() {
        if (this.x < 2) x = 2;
        if (this.y < 28) y = 28;
        if(this.x > (TankFrame.GAME_WIDTH - Tank.WIDTH - 2)) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        if(this.y > (TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2)) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
    }

    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
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

    /**
     * 发射子弹
     */
    public void fire() {
        //计算子弹发出的位置
        int bx = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tankFrame.bullets.add(new Bullet(bx, by, this.dir, this.group, this.tankFrame));

        //子弹开火的声音
        if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
