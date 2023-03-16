package com.darren.center.designpatterns.observer.supper.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>demo</h3>
 * <p>房屋中介</p>
 *
 * @author : Darren
 * @date : 2020年11月04日 18:49:20
 **/
public class Realtor {

    /**
     * 租客集合
     */
    private List<Tenant> tenants = new ArrayList();

    /**
     * 房子集合
     */
    private List<House> houses = new ArrayList<>();

    public void addTenant(Tenant tenant){
        tenants.add(tenant);
    }

    public void addHouse(House house){
        houses.add(house);
    }

    public void notifyTenant(){
        for (Tenant tenant : tenants) {
            tenant.tenement(houses);
        }
    }
}
