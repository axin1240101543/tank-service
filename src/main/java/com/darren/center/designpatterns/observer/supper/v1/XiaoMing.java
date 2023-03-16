package com.darren.center.designpatterns.observer.supper.v1;

import java.util.List;

/**
 * <h3>demo</h3>
 * <p>小明</p>
 *
 * @author : Darren
 * @date : 2020年11月04日 18:47:04
 **/
public class XiaoMing extends Tenant{
    protected House house;

    protected Realtor realtor;

    public XiaoMing(Realtor realtor){
        this.house = new House(null, "三室两厅", 6000);
        this.realtor = realtor;
        this.realtor.addTenant(this);
    }

    /**
     * 小明去租房
     */
    @Override
    public void tenement(List<House> house) {
        for (House myHouse : house) {
            if (this.house.getMoney() >= myHouse.getMoney() && this.house.getLayout().equals(myHouse.getLayout())){
                System.out.println("小明：" + myHouse);
            }
        }
    }


}
