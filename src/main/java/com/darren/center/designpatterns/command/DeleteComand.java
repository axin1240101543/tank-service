package com.darren.center.designpatterns.command;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2020年07月30日 10:43:31
 **/
public class DeleteComand extends Command{

    Content content;
    String deleted;

    public DeleteComand(Content content) {
        this.content = content;
    }

    @Override
    void exec() {
        deleted = content.msg.substring(0, 5);
        content.msg = content.msg.substring(5, content.msg.length());
    }

    @Override
    void undo() {
        content.msg = deleted + content.msg;
    }
}
