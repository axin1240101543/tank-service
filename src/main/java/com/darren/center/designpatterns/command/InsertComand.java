package com.darren.center.designpatterns.command;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2020年07月30日 10:43:31
 **/
public class InsertComand extends Command{

    Content content;
    String strToInsert = "http://www.mashibing.com";

    public InsertComand(Content content) {
        this.content = content;
    }

    @Override
    void exec() {
        content.msg = content.msg + strToInsert;
    }

    @Override
    void undo() {
        content.msg = content.msg.substring(0, content.msg.length() - strToInsert.length());
    }
}
