package com.darren.center.designpatterns.observer.v6;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>tank-service</h3>
 * <p>观察者需要根据事件的具体情况来进行处理</p>
 *
 * @author : Darren
 * @date : 2020年07月27日 22:09:42
 **/
interface Observer{
    void actionOnWakeUp(WakeUpEvent event);
}

class Dad implements Observer{
    public void feed(){
        System.out.println("dad feeding...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        System.out.println("event:" + event);
        feed();
    }
}

class Mum implements Observer{
    public void hug(){
        System.out.println("mum hugging...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        System.out.println("event:" + event);
        hug();
    }
}

class Dog implements Observer{
    public void wang(){
        System.out.println("dog wang...");
    }

    @Override
    public void actionOnWakeUp(WakeUpEvent event) {
        System.out.println("event:" + event);
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

        WakeUpEvent event = new WakeUpEvent(System.currentTimeMillis(), "bed");

        for (Observer observer : observers) {
            observer.actionOnWakeUp(event);
        }
    }
}

//事件类
class WakeUpEvent{
    //哭的时间
    long timestamp;
    //哭的地点
    String loc;

    public WakeUpEvent(long timestamp, String loc) {
        this.timestamp = timestamp;
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "WakeUpEvent{" +
                "timestamp=" + timestamp +
                ", loc='" + loc + '\'' +
                '}';
    }
}

public class Main6 {

    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }

}

