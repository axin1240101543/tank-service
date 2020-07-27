package com.darren.center.designpatterns.observer.v9;

import java.awt.Button;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

/**
 * <h3>tank-service</h3>
 * <p>Frame框架的观察者模式实现</p>
 *
 * @author : Darren
 * @date : 2020年07月27日 22:46:24
 **/
public class Main92 extends Frame {

    public static void main(String[] args) {
        new Main92().launch();
    }

    public void launch() {
        Button button = new Button("press me");
        //添加观察者到队列
        button.addActionListener(new MyActionListener1());
        button.addActionListener(new MyActionListener2());
        this.add(button);
        //调用被观察者的逻辑
        this.pack();

        //之外的逻辑，可以忽略
        this.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

        });
        this.setLocation(400, 400);
        this.setVisible(true);
    }

    /**
     * 观察者1
     */
    private class  MyActionListener1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            System.out.println("source:" + source);
            ((Button)e.getSource()).setLabel("press me again……");
            System.out.println("MyActionListener1 ……");
        }
    }

    /**
     * 观察者2
     */
    private class  MyActionListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("MyActionListener2 ……");
        }
    }

}

