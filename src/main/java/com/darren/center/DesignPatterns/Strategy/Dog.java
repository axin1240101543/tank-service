package com.darren.center.DesignPatterns.Strategy;

/**
 * <h3>tank-service</h3>
 * <p>排序实体2</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 14:08:48
 **/
public class Dog implements Comparable<Dog>{

    int food;

    public Dog(int food) {
        this.food = food;
    }

    @Override
    public int compareTo(Dog d) {
        if(this.food > d.food) return 1;
        else if(this.food < d.food) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
