package com.darren.center;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        //初始化敌方坦克
        for (int i = 0; i < 5; i++) {
            tf.tanks.add(new Tank(50 + i*80, 200, Dir.DOWN, tf));
        }

        while (true){
            Thread.sleep(50);
            //默认调用paint方法
            tf.repaint();
        }
    }

}
