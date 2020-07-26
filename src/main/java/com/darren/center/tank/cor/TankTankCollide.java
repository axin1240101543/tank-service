package com.darren.center.tank.cor;

import com.darren.center.tank.GameObject;
import com.darren.center.tank.Tank;

/**
 * <h3>tank-service</h3>
 * <p>坦克和坦克相撞</p>
 *
 * @author : Darren
 * @date : 2020年07月24日 17:00:45
 **/
public class TankTankCollide implements Collider<GameObject>{

    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank){
            Tank tank1 = (Tank) o1;
            Tank tank2 = (Tank) o2;
            /*if (tank1.rTank.intersects(tank2.rTank)){
                tank1.backDir();
                tank2.backDir();
            }*/
        }
        return true;
    }
}
