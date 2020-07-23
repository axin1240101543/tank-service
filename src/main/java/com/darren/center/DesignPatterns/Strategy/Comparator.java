package com.darren.center.DesignPatterns.Strategy;

/**
 * <h3>tank-service</h3>
 * <p>比较器</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 14:21:58
 **/
public interface Comparator<T>{

    int compare(T o1, T o2);

}
