package com.darren.center.designpatterns.command.me;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2022年06月24日 22:50:44
 **/
public class Main {
    /**
     * client
     * @param args
     */
    public static void main(String[] args) {
        //命令执行者
        RestService restService = new RestService();
        //具体的命令
        HystrixCommand command = new HystrixHttpClientCommand(restService);
        //调用者
        Invoker invoker = new Invoker(command);
        invoker.run();
    }

}

