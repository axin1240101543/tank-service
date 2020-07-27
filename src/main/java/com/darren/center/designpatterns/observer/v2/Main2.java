package com.darren.center.designpatterns.observer.v2;

/**
 * <h3>tank-service</h3>
 * <p>版本2</p>
 *
 * 面向对象的傻等
 *
 * @author : Darren
 * @date : 2020年07月27日 21:51:44
 **/

class Child{

    private boolean cry = false;

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        System.out.println("Waked Up! Crying wuwuwuwu...");
        cry = true;
    }
}
public class Main2 {

    public static void main(String[] args) {
        Child child = new Child();

        while (!child.isCry()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observing...");
        }
    }



}

