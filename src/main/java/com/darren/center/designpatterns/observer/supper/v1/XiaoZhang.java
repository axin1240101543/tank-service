package com.darren.center.designpatterns.observer.supper.v1;

import java.util.List;

/**
 * <h3>demo</h3>
 * <p>小张</p>
 *
 * @author : Darren
 * @date : 2020年11月04日 18:47:04
 **/
public class XiaoZhang extends Tenant{

    public XiaoZhang(Realtor realtor){
        this.realtor = realtor;
        this.house = new House(null, null, 1500);
        this.realtor.addTenant(this);
    }

    /**
     * 小张去租房
     */
    @Override
    public void tenement(List<House> house) {
        for (House myHouse : house) {
            if (1500 >= myHouse.getMoney()){
                System.out.println("小张:" + myHouse);
            }
        }
    }
}
