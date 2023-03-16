package com.darren.center.designpatterns.observer.supper.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>demo</h3>
 * <p>租客</p>
 *
 * @author : Darren
 * @date : 2020年11月04日 18:34:15
 **/
public abstract class Tenant {

    protected List<Realtor> realtors = new ArrayList<>();

    public void add(Realtor realtor){
        realtors.add(realtor);
    }

    /**
     * 需要什么样的房子
     */
    public abstract void requireHouse();

    /**
     * 去租房
     */
    public abstract void tenement(House house);

}
