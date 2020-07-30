package com.darren.center.designpatterns.state.thread;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2020年07月30日 14:32:09
 **/
public class Thread_ {

    ThreadState_ state;

    void move(Action action){
        state.move(action);
    }

    void run(){
        state.run();
    }

}
