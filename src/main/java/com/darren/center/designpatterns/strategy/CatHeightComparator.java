package com.darren.center.designpatterns.strategy;

/**
 * <h3>tank-service</h3>
 * <p>猫的高度的比较器</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 14:38:49
 **/
public class CatHeightComparator implements Comparator<Cat>{

    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.height < o2.height) return 1;
        else if (o1.height > o2.height) return -1;
        else return 0;
    }
}
