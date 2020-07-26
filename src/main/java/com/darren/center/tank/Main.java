package com.darren.center.tank;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        //new Thread(()->new Audio("audio/war1.wav").loop()).start();

        while (true){
            Thread.sleep(50);
            //默认调用paint方法
            tf.repaint();
        }
    }

}
