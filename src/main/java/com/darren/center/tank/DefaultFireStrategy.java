package com.darren.center.tank;

import com.darren.center.tank.factory.BaseTank;

/**
 * <h3>tank-service</h3>
 * <p>发射子弹的默认策略</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 15:39:05
 **/
public class DefaultFireStrategy implements FireStategy{

    @Override
    public void fire(BaseTank tank) {
        //计算子弹发出的位置
        int bx = tank.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = tank.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        //new Bullet(bx, by, tank.dir, tank.group, tank.tankFrame);
        //通过抽象工厂来创建子弹
        tank.tankFrame.factory.createBullet(bx, by, tank.dir, tank.group, tank.tankFrame);
        //子弹开火的声音
        if(tank.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }
}
