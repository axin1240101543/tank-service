package com.darren.center.designpatterns.observer.v3;

/**
 * <h3>tank-service</h3>
 * <p>版本3</p>
 *
 * 加入观察者
 * @author : Darren
 * @date : 2020年07月27日 21:54:58
 **/
class Child{

    private boolean cry = false;

    private Dad d = new Dad();

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        System.out.println("Waked Up! Crying wuwuwuwu...");
        cry = true;
        d.feed();
    }
}

class Dad{
    public void feed(){
        System.out.println("dad feeding...");
    }
}

public class Main3 {

    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }

}

