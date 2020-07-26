package com.darren.center.tank;

import java.awt.*;

/**
 * <h3>tank-service</h3>
 * <p>子弹</p>
 *
 * @author : Darren
 * @date : 2020年07月22日 09:23:33
 **/
public class Bullet extends GameObject{

    //坐标
    private int x, y;
    //方向
    private Dir dir;
    //速度
    private static final int SPEED = PropertyMgr.getInt("bulletSpeed");
    //大小
    public static int WIDTH = ResourceMgr.getInstance().bulletU.getWidth();
    public static int HEIGHT = ResourceMgr.getInstance().bulletU.getHeight();

    //因为子弹没有删除，会发生内存泄露，所以要判断子弹超出windows就删除子弹
    private boolean living = true;
    //将我方坦克子弹和敌方坦克子弹进行区分
    public Group group = Group.BAD;

    //因为每次碰撞检测都会产生两个Rectangle对象，假如有n个子弹和m个坦克，
    // 那么产生的对象就是2*n*m，所以在坦克和子弹内部维护一个Rectangle来记录这个坦克和子弹的位置
    public Rectangle rBullet = new Rectangle();


    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        //对内部维护的Rectangle进行初始化
        this.rBullet.x = this.x;
        this.rBullet.y = this.y;
        this.rBullet.width = WIDTH;
        this.rBullet.height = HEIGHT;

        //new出一颗子弹直接添加到子弹的集合中
        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics g) {
        if (!living){
            GameModel.getInstance().remove(this);
        }

        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.getInstance().bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.getInstance().bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.getInstance().bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.getInstance().bulletD, x, y, null);
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

        //对内部维护的Rectangle进行更新
        this.rBullet.x = this.x;
        this.rBullet.y = this.y;

        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;
    }

    public void die() {
        living = false;
    }
}
