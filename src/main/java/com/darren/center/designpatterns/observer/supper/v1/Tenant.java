package com.darren.center.designpatterns.observer.supper.v1;

import java.util.List;

/**
 * <h3>demo</h3>
 * <p>租客</p>
 *
 * @author : Darren
 * @date : 2020年11月04日 18:47:23
 **/
public abstract class Tenant {

    protected House house;

    protected Realtor realtor;

    /**
     * 租房子
     */
    public abstract void tenement(List<House> house);
}
