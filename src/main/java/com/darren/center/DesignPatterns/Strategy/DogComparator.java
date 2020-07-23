package com.darren.center.DesignPatterns.Strategy;

/**
 * <h3>tank-service</h3>
 * <p>狗的比较器</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 14:38:49
 **/
public class DogComparator implements Comparator<Dog>{

    @Override
    public int compare(Dog o1, Dog o2) {
        if (o1.food > o2.food) return 1;
        else if (o1.food < o2.food) return -1;
        else return 0;
    }
}
