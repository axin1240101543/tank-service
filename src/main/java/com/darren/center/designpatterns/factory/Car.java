package com.darren.center.designpatterns.factory;

/**
 * <h3>tank-service</h3>
 * <p>车</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 16:39:07
 **/
public class Car implements Removeable{

    @Override
    public void go(){
        System.out.println("Car go ………………");
    }
}
