package com.darren.center;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

            //监听键盘事件
            addKeyListener(new MyKeyListener());

            //监听关闭窗口事件
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
        //x += 10;
        //y += 10;
    }

    class MyKeyListener extends KeyAdapter{

        boolean bu = false;
        boolean bd = false;
        boolean bl = false;
        boolean br = false;

        @Override
        public void keyPressed(KeyEvent e) {
            //键被按下
            //System.out.println("keyPressed");
            //x += 200;
            //默认调用paint方法
            //repaint();

            //通过键确定tank的方向
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_UP:
                    bu = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bl = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                default:
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            //键被弹起
            //System.out.println("keyReleased");
            int keyCode = e.getKeyCode();
            switch (keyCode){
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bl = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                default:
                    break;
            }
        }
    }

}
