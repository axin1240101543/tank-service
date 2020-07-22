package com.darren.center;


import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * 写一个新窗口
 */
public class TankFrame extends Frame {

    Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);
    List<Bullet> bullets = new ArrayList<>();
    List<Tank> tanks = new ArrayList<>();
    List<Explode> explodes = new ArrayList<>();
    //Bullet bullet = new Bullet(200, 200, Dir.DOWN, this);
    final int GAME_WIDTH = 1080, GAME_HEIGHT = 960;

    //Explode explode = new Explode(200, 200, this);

    public TankFrame(){
            //设置大小
            setSize(GAME_WIDTH, GAME_HEIGHT);
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
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量：" + bullets.size(), 10, 60);
        g.drawString("敌人的数量：" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量：" + explodes.size(), 10, 100);
        g.setColor(color);

        //画出我方坦克
        myTank.paint(g);
        //Exception in thread "AWT-EventQueue-0" java.util.ConcurrentModificationException
        /*for (Bullet b : bullets) {
            b.paint(g);
        }*/

        //画出子弹
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }

        //画出敌方坦克
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }

        //画出爆炸
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        //碰撞检测：当子弹撞上坦克，子弹死亡，坦克死亡
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));
            }
        }

        //画出一个爆炸
        //explode.paint(g);
    }


    Image offScreenImage = null;
    /**
     * 处理双缓冲，解决闪烁问题
     * update方法会在paint之前调用
     *
     * 内存中先创建一个和屏幕大小一致的图片，然后用图片的画笔将坦克和子弹画在图片上，
     * 然后使用屏幕的画笔将整个图片画到屏幕上（将内存的内容复制到显存）。
     * @param g
     */
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null){
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.black);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
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
            setMainTankDir();

            //坦克开动的声音
            new Thread(()->new Audio("audio/tank_move.wav").play()).start();
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

                case KeyEvent.VK_F2:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            //如果上下左右键都没有按下，那么moving设置为false
            if (!bu && !bd && !bl && !br){
                myTank.setMoving(false);
            }else{
                myTank.setMoving(true);
                if (bu) myTank.setDir(Dir.UP);
                if (bd) myTank.setDir(Dir.DOWN);
                if (bl) myTank.setDir(Dir.LEFT);
                if (br) myTank.setDir(Dir.RIGHT);
            }
        }
    }
}
