package com.darren.center.tank;

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

    List<Bullet> bullets = new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();

    public GameModel() {
        //初始化敌方坦克
        int initTankCount =  PropertyMgr.getInt("initTankCount");
        for (int i = 0; i < initTankCount; i++) {
            tanks.add(new Tank(50 + i*80, 200, Dir.DOWN, Group.BAD, this));
        }
    }

    /**
     * 窗口重新绘制的时候自动调用
     * @param g
     */
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.drawString("敌人的数量：" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量：" + explodes.size(), 10, 100);
        g.setColor(color);

        //画出我方坦克
        myTank.paint(g);

        //画出子弹
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        //画出敌方坦克
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        //画出爆炸
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        //碰撞检测：当子弹撞上坦克，子弹死亡，坦克死亡
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
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
