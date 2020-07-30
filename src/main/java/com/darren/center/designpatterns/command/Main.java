package com.darren.center.designpatterns.command;

import java.util.ArrayList;

/**
 * <h3>tank-service</h3>
 * <p>command设计模式</p>
 *
 * @author : Darren
 * @date : 2020年07月30日 11:01:55
 **/
public class Main {

    public static void main(String[] args) {
        Content c = new Content();

        Command insertComand = new InsertComand(c);
        insertComand.exec();
        System.out.println("insertComand：" + c.msg);
        insertComand.undo();
        System.out.println("insertComand：" + c.msg);

        Command copyComand = new CopyComand(c);
        copyComand.exec();
        System.out.println("copyComand：" + c.msg);
        copyComand.undo();
        System.out.println("copyComand：" + c.msg);

        Command deleteComand = new DeleteComand(c);
        deleteComand.exec();
        System.out.println("deleteComand：" + c.msg);
        deleteComand.undo();
        System.out.println("deleteComand：" + c.msg);

        //通过command + cor，实现多个undo功能
        ArrayList<Command> commands = new ArrayList<>();
        commands.add(new InsertComand(c));
        commands.add(new CopyComand(c));
        commands.add(new DeleteComand(c));

        for (Command command : commands) {
            command.exec();
        }

        System.out.println("mul commands：" + c.msg);

        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }

        System.out.println("mul commands：" + c.msg);
    }

}
