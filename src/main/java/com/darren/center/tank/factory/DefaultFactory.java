package com.darren.center.tank.factory;

import com.darren.center.tank.*;

/**
 * <h3>tank-service</h3>
 * <p>默认的具体工厂</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 22:37:38
 **/
public class DefaultFactory extends GameFactory {

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Tank(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Bullet(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new Explode(x, y, tankFrame);
    }
}

