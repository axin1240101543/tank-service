package com.darren.center.designpatterns.observer.supper.v2;

/**
 * <h3>demo</h3>
 * <p>房屋中介</p>
 *
 * @author : Darren
 * @date : 2020年11月04日 18:35:56
 **/
public interface Realtor {

    /**
     * 房屋中介去找房子
     * @param event
     */
    void findHouse(TenementEvent event);

}
