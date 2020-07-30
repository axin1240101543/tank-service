package com.darren.center.designpatterns.state.thread;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2020年07月30日 14:31:39
 **/
public class TerminatedState extends ThreadState_{

    private Thread_ t;

    public TerminatedState(Thread_ t) {
        this.t = t;
    }

    @Override
    void move(Action action) {

    }

    @Override
    void run() {

    }
}
