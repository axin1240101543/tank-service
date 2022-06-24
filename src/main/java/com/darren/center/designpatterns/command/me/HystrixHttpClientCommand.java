package com.darren.center.designpatterns.command.me;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2022年06月24日 22:46:02
 **/
public class HystrixHttpClientCommand implements HystrixCommand{

    private RestService restService;

    public HystrixHttpClientCommand(RestService restService) {
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

