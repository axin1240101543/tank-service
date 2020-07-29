package com.darren.center.designpatterns.proxy.spring.v1;

/**
 * <h3>tank-service</h3>
 * <p>代理类</p>
 *
 * @author : Darren
 * @date : 2020年07月28日 15:01:03
 **/
public class TimeProxy {

    public void before(){
        System.out.println("start moving……");
    }

    public void after(){
        System.out.println("start stopped!!!");
    }

}
