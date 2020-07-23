package com.darren.center.designpatterns.factory.abstractfactory;

/**
 * <h3>tank-service</h3>
 * <p>车</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 16:39:07
 **/
public class Car extends Vehicle{

    @Override
    public void go(){
        System.out.println("Car go ………………");
    }
}
