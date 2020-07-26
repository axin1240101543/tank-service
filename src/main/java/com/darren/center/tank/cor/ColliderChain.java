package com.darren.center.tank.cor;

import com.darren.center.tank.GameObject;
import com.darren.center.tank.PropertyMgr;

import java.util.LinkedList;
import java.util.List;

/**
 * <h3>tank-service</h3>
 * <p>责任链模式</p>
 *
 * @author : Darren
 * @date : 2020年07月26日 10:36:10
 **/
public class ColliderChain implements Collider<GameObject>{

    List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        /*colliders.add(new BulletTankCollide());
        colliders.add(new TankTankCollide());*/
        //使用配置文件在加载链条
        String[] strings = PropertyMgr.getStr("colliders").split(",");
        for (int i = 0; i < strings.length; i++) {
            try {
                colliders.add((Collider) Class.forName(strings[i]).getDeclaredConstructor().newInstance());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (!colliders.get(i).collide(o1, o2)){
                //发生碰撞
                return false;
            }
        }
        return true;
    }
}
