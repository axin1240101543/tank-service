package com.darren.center.designpatterns.state.v2;

/**
 * <h3>tank-service</h3>
 * <p>State设计模式</p>
 *
 * 问题：当增加新的状态时非常不方便
 * 根据状态决定动作
 *
 * @author : Darren
 * @date : 2020年07月30日 14:22:08
 **/
public class Girl {

    String name;

    GirlState state = new GirlHappyState();

    public void smile(){
        state.smile();
    }

    public void cry(){
        state.cry();
    }

    public void say(){
        state.say();
    }

}
