package com.darren.center.designpatterns.command.me;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * https://www.freesion.com/article/6307256889/
 *
 * @author : Darren
 * @date : 2022年06月24日 22:42:26
 **/
public interface HystrixCommand {

    /**
     * 执行
     */
    void run();

    /**
     * 撤销
     */
    void undo();

}

