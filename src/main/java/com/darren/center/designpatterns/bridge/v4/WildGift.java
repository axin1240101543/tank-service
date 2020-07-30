package com.darren.center.designpatterns.bridge.v4;

/**
 * <h3>tank-service</h3>
 * <p></p>
 * 
 * @author : Darren
 * @date : 2020年07月30日 10:08:42
 **/
public class WildGift extends Gift {

    public WildGift(GiftImpl impl) {
        this.impl = impl;
    }

    @Override
    public String toString() {
        return "WildGift{" +
                "impl=" + impl +
                '}';
    }

}
