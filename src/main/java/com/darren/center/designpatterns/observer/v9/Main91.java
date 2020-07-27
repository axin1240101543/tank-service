package com.darren.center.designpatterns.observer.v9;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>tank-service</h3>
 * <p>Test</p>
 *
 * @author : Darren
 * @date : 2020年07月27日 22:36:50
 **/
public class Main91 {

    public static void main(String[] args) {
        Button button = new Button();
        button.addActionListener(new MyActionListener1());
        button.addActionListener(new MyActionListener2());
        button.buttonPress();
    }

}

/**
 * 被观察者
 */
class Button{

    private List<ActionListener> observers = new ArrayList<>();

    public void buttonPress(){
        ActionEvent event = new ActionEvent(System.currentTimeMillis(), this);
        for (ActionListener observer : observers) {
            observer.actionPerFormed(event);
        }
    }

    public void addActionListener(ActionListener actionListener){
        observers.add(actionListener);
    }

}

/**
 * 要观察的行为
 */
interface ActionListener{
    void actionPerFormed(ActionEvent event);
}

/**
 * 观察者1
 */
class MyActionListener1 implements ActionListener{

    @Override
    public void actionPerFormed(ActionEvent event) {
        System.out.println("MyActionListener1 ……");
    }
}

/**
 * 观察者2
 */
class MyActionListener2 implements ActionListener{

    @Override
    public void actionPerFormed(ActionEvent event) {
        System.out.println("MyActionListener2 ……");
    }
}

abstract class Event<T>{
    abstract T getSource();
}

//被观察者产生的事件
class ActionEvent extends Event<Object>{

    long when;

    Object source;

    public ActionEvent(long when, Object source) {
        this.when = when;
        this.source = source;
    }

    long getWhen(){
        return when;
    }

    @Override
    Object getSource() {
        return source;
    }
}



