package com.darren.center.designpatterns.command;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2020年07月30日 10:42:38
 **/
public abstract class Command {

    abstract void exec();

    abstract void undo();

}
