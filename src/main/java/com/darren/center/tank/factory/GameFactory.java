package com.darren.center.tank.factory;

import com.darren.center.tank.Dir;
import com.darren.center.tank.Group;
import com.darren.center.tank.TankFrame;

/**
 * <h3>tank-service</h3>
 * <p>父类抽象工厂</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 22:33:04
 **/
public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame);

    public abstract BaseExplode createExplode(int x, int y, TankFrame tankFrame);

}

