package com.darren.center.designpatterns.state.v1;

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

    private enum GirlState{HAPPY, SAD}

    GirlState state;

    public void smile(){
        switch (state) {
            case HAPPY:
                break;
            case SAD:
                break;
        }
    }

    public void cry(){
        switch (state) {
            case HAPPY:
                break;
            case SAD:
                break;
        }
    }

    public void say(){
        switch (state) {
            case HAPPY:
                break;
            case SAD:
                break;
        }
    }

}
