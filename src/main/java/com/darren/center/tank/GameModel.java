package com.darren.center.tank;

import com.darren.center.tank.cor.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>tank-service</h3>
 * <p>门面模式</p>
 *
 * 抽象出GameModel，将Model和View分离，同时，GameModel作为Facade，负责与Frame打交道，同时负责内部事务。
 *
 * @author : Darren
 * @date : 2020年07月24日 14:56:16
 **/
public class GameModel {


    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);

    List<GameObject> objects = new ArrayList<>();

    ColliderChain colliderChain = new ColliderChain();

    public void add(GameObject object){
        objects.add(object);
    }

    public void remove(GameObject object){
        objects.remove(object);
    }


    public GameModel() {
        //初始化敌方坦克
        int initTankCount =  PropertyMgr.getInt("initTankCount");
        for (int i = 0; i < initTankCount; i++) {
            add(new Tank(50 + i*80, 200, Dir.DOWN, Group.BAD, this));
        }

        //初始化墙
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
    }

    /**
     * 窗口重新绘制的时候自动调用
     * @param g
     */
    public void paint(Graphics g) {
        /*Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.drawString("敌人的数量：" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量：" + explodes.size(), 10, 100);
        g.setColor(color);*/

        //画出我方坦克
        myTank.paint(g);

        //画出游戏物品
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        //碰撞检测：当子弹撞上坦克，子弹死亡，坦克死亡
        for (int i = 0; i < objects.size(); i++) {
            for (int j = 1; j < objects.size(); j++) {
                GameObject gameObject1 = objects.get(i);
                GameObject gameObject2 = objects.get(j);
                //第一种方式是直接遍历colliderChain
                //第二种方式是放在colliderChain中去处理（推荐）
                colliderChain.collide(gameObject1, gameObject2);
            }
        }
    }

    /**
     * 获得我方坦克
     * @return
     */
    public Tank gatMainTank() {
        return myTank;
    }
}
