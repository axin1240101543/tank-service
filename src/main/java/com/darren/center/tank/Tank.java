package com.darren.center.tank;

import com.darren.center.tank.strategy.FireStategy;

import java.awt.*;
import java.util.Random;

/**
 * <h3>tank-service</h3>
 * <p>坦克</p>
 *
 * @author : Darren
 * @date : 2020年07月22日 08:56:52
 **/
public class Tank extends GameObject{

    //坐标
    public int x = 200, y = 200;
    //上一次的坐标，当敌方坦克相撞时，回到此坐标
    int oldX, oldY;

    //方向
    public Dir dir = Dir.DOWN;
    //速度
    private static final int SPEED = PropertyMgr.getInt("tankSpeed");
    //是否移动
    private boolean moving = true;
    //大小
    public static int WIDTH = ResourceMgr.getInstance().goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.getInstance().goodTankU.getHeight();
    //是否存活
    private boolean living = true;
    //随机数
    private Random random = new Random();
    //将我方坦克和敌方坦克进行区分
    public Group group = Group.BAD;

    //因为每次碰撞检测都会产生两个Rectangle对象，假如有n个子弹和m个坦克，
    // 那么产生的对象就是2*n*m，所以在坦克和子弹内部维护一个Rectangle来记录这个坦克和子弹的位置
    public Rectangle rTank = new Rectangle();

    //发射子弹的策略
    FireStategy fireStategy;

    public Tank(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        //对内部维护的Rectangle进行初始化
        this.rTank.x = this.x;
        this.rTank.y = this.y;
        this.rTank.width = WIDTH;
        this.rTank.height = HEIGHT;

        //我方坦克使用FourFireStategy策略，敌方坦克使用DefaultFireStategy
        //遵循开闭原则，使用配置文件的方式，添加新的策略类之后修改配置文件即可
        try {
            if (group == Group.GOOD) {
                fireStategy = (FireStategy)Class.forName(PropertyMgr.getStr("goodFs")).getDeclaredConstructor().newInstance();
            } else{
                fireStategy = (FireStategy)Class.forName(PropertyMgr.getStr("badFs")).getDeclaredConstructor().newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics g) {

        //要移除list中的元素，否则会内存泄漏
        if (!living) GameModel.getInstance().remove(this);

        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.getInstance().goodTankL : ResourceMgr.getInstance().badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.getInstance().goodTankU : ResourceMgr.getInstance().badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.getInstance().goodTankR : ResourceMgr.getInstance().badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.getInstance().goodTankD : ResourceMgr.getInstance().badTankD, x, y, null);
                break;
        }
        move();
    }

    private void move() {
        //记录上一次的坐标
        oldX = x;
        oldY = y;

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

        //边界检测：敌方坦克撞墙的处理
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
     * 有两种方式
     * 1、将发射策略作为成员变量
     *  作用域不同，成员变量的作用域是整个类，而参数是本方法
     *  FireStategy fireStategy = new DefaultFireStategy();
     * 2、将发射策略作为参数传进来
     *  每次new一个FireStategy传进来，可以直接做成单例传进来
     *  public void fire(FireStategy fireStategy){
     *      to do
     *  }
     */
    public void fire() {
        fireStategy.fire(this);
    }

    /**
     * 当敌方坦克相撞时, 回到上一次的坐标
     */
    public void backDir(){
        x = oldX;
        y = oldY;
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
