package com.darren.center.DesignPatterns.Strategy;

/**
 * <h3>tank-service</h3>
 * <p>猫的重量的比较器</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 14:38:49
 **/
public class CatWeightComparator implements Comparator<Cat>{

    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.weight > o2.weight) return 1;
        else if (o1.weight < o2.weight) return -1;
        else return 0;
    }
}
