package com.darren.center.tank.cor;

import com.darren.center.tank.*;

/**
 * <h3>tank-service</h3>
 * <p>子弹和墙相撞</p>
 *
 * @author : Darren
 * @date : 2020年07月26日 14:55:45
 **/
public class BulletWallCollide implements Collider<GameObject>{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall){
            Bullet bullet = (Bullet) o1;
            Wall wall = (Wall) o2;
            if (bullet.rBullet.intersects(wall.rect)){
                bullet.die();
            }
        }else if (o1 instanceof Wall && o2 instanceof Bullet){
           return collide(o2, o1);
        }
        return true;
    }
}
