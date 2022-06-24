package com.darren.center.designpatterns.command.me;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2022年06月24日 22:49:41
 **/
public class Invoker {

    private HystrixCommand hystrixCommand;

    public Invoker(HystrixCommand hystrixCommand) {
        this.hystrixCommand = hystrixCommand;
    }

    public void run(){
        hystrixCommand.run();
    }
}

