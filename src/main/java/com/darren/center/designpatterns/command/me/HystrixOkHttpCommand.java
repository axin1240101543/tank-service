package com.darren.center.designpatterns.command.me;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2022年06月24日 22:48:12
 **/
public class HystrixOkHttpCommand implements HystrixCommand{

    private RestService restService;

    public HystrixOkHttpCommand(RestService restService) {
        this.restService = restService;
    }

    @Override
    public void run() {
        restService.run();
    }

    @Override
    public void undo() {
        restService.undo();
    }
}

