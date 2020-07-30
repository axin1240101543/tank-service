package com.darren.center.designpatterns.bridge.v4;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2020年07月30日 10:08:24
 **/
public class WarmGift extends Gift {

    public WarmGift(GiftImpl impl) {
        this.impl = impl;
    }

    @Override
    public String toString() {
        return "WarmGift{" +
                "impl=" + impl +
                '}';
    }
}
