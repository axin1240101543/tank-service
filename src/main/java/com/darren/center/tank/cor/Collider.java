package com.darren.center.tank.cor;

/**
 * <h3>tank-service</h3>
 * <p>碰撞器</p>
 *
 * @author : Darren
 * @date : 2020年07月24日 16:49:16
 **/
public interface Collider<T> {

    void collide(T o1, T o2);

}
