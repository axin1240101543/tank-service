package com.darren.center.designpatterns.state.thread;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2020年07月30日 14:30:01
 **/
public abstract class ThreadState_ {

    abstract void move(Action action);

    abstract void run();

}