package com.darren.center.tank.factory;

import com.darren.center.tank.*;

/**
 * <h3>tank-service</h3>
 * <p>方形的具体工厂</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 22:37:38
 **/
public class RectFactory extends GameFactory {

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return null;
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new RectExplode(x, y, tankFrame);
    }
}

