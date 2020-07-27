package com.darren.center.designpatterns.observer.v4;

/**
 * <h3>tank-service</h3>
 * <p>加入多个观察者</p>
 *
 * @author : Darren
 * @date : 2020年07月27日 21:58:38
 **/
class Child{

    private boolean cry = false;

    private Dad d = new Dad();
    private Mum m = new Mum();
    private Dog dog = new Dog();

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        System.out.println("Waked Up! Crying wuwuwuwu...");
        cry = true;
        d.feed();
        m.hug();
        dog.wang();
    }
}

class Dad{
    public void feed(){
        System.out.println("dad feeding...");
    }
}

class Mum{
    public void hug(){
        System.out.println("mum hugging...");
    }
}

class Dog{
    public void wang(){
        System.out.println("dog wang...");
    }
}

public class Main4 {

    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }

}

