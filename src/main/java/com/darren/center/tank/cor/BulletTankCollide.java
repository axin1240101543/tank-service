package com.darren.center.tank.cor;

import com.darren.center.tank.Bullet;
import com.darren.center.tank.Explode;
import com.darren.center.tank.GameObject;
import com.darren.center.tank.Tank;

/**
 * <h3>tank-service</h3>
 * <p>子弹和坦克相撞</p>
 *
 * @author : Darren
 * @date : 2020年07月24日 16:50:45
 **/
public class BulletTankCollide implements Collider<GameObject>{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank){
            Bullet bullet = (Bullet) o1;
            Tank tank = (Tank) o2;
            //自己不伤害自己
            if (bullet.group == tank.getGroup()) return false;

            if (bullet.rBullet.intersects(tank.rTank)){
                tank.die();
                bullet.die();
                //计算坦克爆炸的位置
                int ex = tank.getX() + Tank.WIDTH/2 - Explode.WIDTH/2;
                int ey = tank.getY() + Tank.HEIGHT/2 - Explode.HEIGHT/2;
                bullet.gm.add(new Explode(ex, ey, bullet.gm));
                return true;
            }
        }else if (o1 instanceof Tank && o2 instanceof Bullet){
           return collide(o2, o1);
        }
        return false;
    }
}
