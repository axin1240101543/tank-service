package com.darren.center.designpatterns.observer.supper.v2;

/**
 * <h3>demo</h3>
 * <p>租客小明</p>
 *
 * 三室两厅且租金不超过6000的房子
 *
 * @author : Darren
 * @date : 2020年11月04日 18:51:44
 **/
public class XiaoMing extends Tenant{

    public XiaoMing() {
        super.add(new BigHouse());
    }

    @Override
    public void requireHouse() {
        TenementEvent event = new TenementEvent(this);
        for (Realtor realtor : realtors) {
            realtor.findHouse(event);
        }
    }

    @Override
    public void tenement(House house) {
        System.out.println("租客小明：" + house);
    }
}
