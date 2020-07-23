package com.darren.center.designpatterns.strategy;

/**
 * <h3>tank-service</h3>
 * <p>排序实体1</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 12:21:00
 **/
public class Cat implements Comparable<Cat>{

    int weight, height;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    /*public int compareTo(Cat c){
        if(this.weight > c.weight) return 1;
        else if(this.weight < c.weight) return -1;
        else return 0;
    }*/

    @Override
    public int compareTo(Cat c) {
        if(this.weight > c.weight) return 1;
        else if(this.weight < c.weight) return -1;
        else return 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
