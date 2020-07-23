package com.darren.center.DesignPatterns.Factory;

/**
 * <h3>tank-service</h3>
 * <p>飞机</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 16:40:22
 **/
public class Plane implements Removeable{

    @Override
    public void go(){
        System.out.println("Plane frying ………………");
    }

}
