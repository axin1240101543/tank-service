package com.darren.center.designpatterns.templatemethod;

/**
 * <h3>tank-service</h3>
 * <p>模板方法设计模式</p>
 *
 * 钩子函数或者回调函数
 *
 * @author : Darren
 * @date : 2020年07月30日 14:10:26
 **/
public class Main {

    public static void main(String[] args) {
        A b = new B();
        b.templateMethod();
    }

}

abstract class A{

    public void templateMethod(){
        operation1();
        operation2();
    }

    abstract void operation1();

    abstract void operation2();

}

class B extends A{
    @Override
    void operation1() {
        System.out.println("operation1");
    }

    @Override
    void operation2() {
        System.out.println("operation2");
    }
}
