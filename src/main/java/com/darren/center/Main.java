package com.darren.center;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        while (true){
            Thread.sleep(50);
            //默认调用paint方法
            tf.repaint();
        }
    }

}
