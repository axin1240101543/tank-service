package com.darren.center.tank;

import com.darren.center.tank.cor.BulletTankCollide;
import com.darren.center.tank.cor.Collider;
import com.darren.center.tank.cor.TankTankCollide;

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
        colliders.add(new BulletTankCollide());
        colliders.add(new TankTankCollide());
    }

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (colliders.get(i).collide(o1, o2)){
                //发生碰撞
                return false;
            }
        }
        return true;
    }
}
