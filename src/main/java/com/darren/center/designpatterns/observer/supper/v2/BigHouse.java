package com.darren.center.designpatterns.observer.supper.v2;

/**
 * <h3>demo</h3>
 * <p>三室两厅且租金不超过6000的房子</p>
 *
 * @author : Darren
 * @date : 2020年11月04日 18:38:32
 **/
public class BigHouse extends House implements Realtor{

    public BigHouse() {
        super("三室两厅", 6000);
    }

    @Override
    public void findHouse(TenementEvent event) {
        Tenant tenant = event.getTenant();
        tenant.tenement(new BigHouse());
    }
}
