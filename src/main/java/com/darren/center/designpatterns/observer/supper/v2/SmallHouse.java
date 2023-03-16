package com.darren.center.designpatterns.observer.supper.v2;

/**
 * <h3>demo</h3>
 * <p>租金不超过1500的房子</p>
 *
 * @author : Darren
 * @date : 2020年11月04日 18:38:32
 **/
public class SmallHouse extends House implements Realtor{

    public SmallHouse() {
        super("单间", 1500);
    }

    @Override
    public void findHouse(TenementEvent event) {
        Tenant tenant = event.getTenant();
        tenant.tenement(new SmallHouse());
    }
}
