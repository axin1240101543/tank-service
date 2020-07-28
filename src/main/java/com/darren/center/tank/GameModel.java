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

    private static final GameModel INSTANCE = new GameModel();

    static {
        INSTANCE.init();
    }

    Tank myTank;

    List<GameObject> objects = new ArrayList<>();

    ColliderChain colliderChain = new ColliderChain();

    public void add(GameObject object){
        objects.add(object);
    }

    public void remove(GameObject object){
        objects.remove(object);
    }


    private GameModel() { }

    /**
     * 考虑消除new GameModel需要new Tank, new Tank又需要new GameModel
     * GameModel . init();
     */
    public void init(){
        //初始化我方坦克
        myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD);

        //初始化敌方坦克
        int initTankCount =  PropertyMgr.getInt("initTankCount");
        for (int i = 0; i < initTankCount; i++) {
            new Tank(50 + i*80, 200, Dir.DOWN, Group.BAD);
        }

        //初始化墙
        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
    }

    public static GameModel getInstance(){
        return INSTANCE;
    }

    /**
     * 窗口重新绘制的时候自动调用
     * @param g
     */
    public void paint(Graphics g) {
        //画出我方坦克
        myTank.paint(g);

        //画出游戏物品
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        //碰撞检测：当子弹撞上坦克，子弹死亡，坦克死亡
        for (int i = 0; i < objects.size(); i++) {
            //i+1  第一次外层for循环，第一个对象和其他每个对象都进行比较，下一次循环的时候，这些对象都和第一个对象比较过了，不需要重新比较，所以只需要比较后面的对象即可
            for (int j = i+1; j < objects.size(); j++) {
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
