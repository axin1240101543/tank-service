package com.darren.center.tank.factory;

import com.darren.center.tank.Dir;
import com.darren.center.tank.Group;
import com.darren.center.tank.PropertyMgr;
import com.darren.center.tank.TankFrame;

import java.awt.*;

/**
 * <h3>tank-service</h3>
 * <p>坦克抽象工厂</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 22:33:57
 **/
public abstract class BaseTank {

    //坐标
    public int x = 200, y = 200;
    //方向
    public Dir dir = Dir.DOWN;

    //将我方坦克和敌方坦克进行区分
    public Group group = Group.BAD;

    //将子弹传给windows
    public TankFrame tankFrame = null;

    //因为每次碰撞检测都会产生两个Rectangle对象，假如有n个子弹和m个坦克，
    // 那么产生的对象就是2*n*m，所以在坦克和子弹内部维护一个Rectangle来记录这个坦克和子弹的位置
    public Rectangle rTank = new Rectangle();

    //是否移动
    public boolean moving = true;

    public abstract void die();

    /**
     * 发射子弹
     * 有两种方式
     * 1、将发射策略作为成员变量
     *  作用域不同，成员变量的作用域是整个类，而参数是本方法
     *  FireStategy fireStategy = new DefaultFireStrategy();
     * 2、将发射策略作为参数传进来
     *  每次new一个FireStategy传进来，可以直接做成单例传进来
     *  public void fire(FireStategy fireStategy){
     *      to do
     *  }
     */
    public abstract void fire();

    public abstract void paint(Graphics g);

}

