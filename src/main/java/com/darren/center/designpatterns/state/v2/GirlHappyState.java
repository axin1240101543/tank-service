package com.darren.center.designpatterns.state.v2;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2020年07月30日 14:26:00
 **/
public class GirlHappyState extends GirlState{

    @Override
    void smile() {
        System.out.println("happy smile");
    }

    @Override
    void cry() {
        System.out.println("happy cry");
    }

    @Override
    void say() {
        System.out.println("happy say");
    }
}
