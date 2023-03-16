package com.darren.center.designpatterns.observer.supper.v2;

/**
 * <h3>demo</h3>
 * <p>租房事件</p>
 *
 * @author : Darren
 * @date : 2020年11月04日 18:33:55
 **/
public class TenementEvent {

    Tenant tenant;

    public TenementEvent(Tenant tenant) {
        this.tenant = tenant;
    }

    public Tenant getTenant() {
        return tenant;
    }
}
