package com.darren.center.designpatterns.observer.v5;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>tank-service</h3>
 * <p>分离观察者与被观察者</p>
 *
 * @author : Darren
 * @date : 2020年07月27日 22:02:36
 **/
interface Observer{
    void actionOnWakeUp();
}

class Dad implements Observer{
    public void feed(){
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp() {
        feed();
    }
}

class Mum implements Observer{
    public void hug(){
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWakeUp() {
        hug();
    }
}

class Dog implements Observer{
    public void wang(){
        System.out.println("dog wang...");
    }

    @Override
    public void actionOnWakeUp() {
        wang();
    }
}

class Child{

    private boolean cry = false;

    private List<Observer> observers = new ArrayList();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean isCry(){
        return cry;
    }

    public void wakeUp(){
        System.out.println("Waked Up! Crying wuwuwuwu...");
        cry = true;
        for (Observer observer : observers) {
            observer.actionOnWakeUp();
        }
    }
}

public class Main5 {

    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }

}

