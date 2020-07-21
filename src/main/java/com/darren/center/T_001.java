package com.darren.center;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 写一个新窗口
 */
public class T_001 {

    public static void main(String[] args) {
        Frame f = new Frame();
        //设置大小
        f.setSize(800, 600);
        //不可改变大小
        f.setResizable(false);
        //设置标题
        f.setTitle("tank war");
        //设置可见
        f.setVisible(true);
        //关闭事件监听
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

}
