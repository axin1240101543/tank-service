package com.darren.center;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 写一个新窗口
 */
public class TankFrame extends Frame {

    int x = 200, y = 200;

    public TankFrame(){
            //设置大小
            setSize(800, 600);
            //不可改变大小
            setResizable(false);
            //设置标题
            setTitle("tank war");
            //设置可见
            setVisible(true);
            //关闭事件监听
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
    }

    /**
     * 窗口重新绘制的时候自动调用
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.fillRect(x, y,50,50);
        x += 10;
        y += 10;
    }
}
