package com.darren.center.tank.cor;

import com.darren.center.tank.Bullet;
import com.darren.center.tank.GameObject;
import com.darren.center.tank.Tank;
import com.darren.center.tank.Wall;

/**
 * <h3>tank-service</h3>
 * <p>坦克和墙相撞</p>
 *
 * @author : Darren
 * @date : 2020年07月26日 14:59:40
 **/
public class TankWallCollide implements Collider<GameObject>{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall){
            Tank tank = (Tank) o1;
            Wall wall = (Wall) o2;
            if (tank.rTank.intersects(wall.rect)){
                tank.backDir();
            }
        }else if (o1 instanceof Wall && o2 instanceof Tank){
           return collide(o2, o1);
        }
        return true;
    }
}
