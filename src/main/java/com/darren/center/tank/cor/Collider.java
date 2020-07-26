package com.darren.center.tank.cor;

/**
 * <h3>tank-service</h3>
 * <p>碰撞器</p>
 *
 * @author : Darren
 * @date : 2020年07月24日 16:49:16
 **/
public interface Collider<T> {

    /**
     *
     * @param o1
     * @param o2
     * @return  发生碰撞 true  没有发生碰撞 false
     */
    boolean collide(T o1, T o2);

}
