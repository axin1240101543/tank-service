package com.darren.center.designpatterns.Iterator.v6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * <h3>tank-service</h3>
 * <p>迭代器设计模式</p>
 *
 * 如何对容器遍历呢？
 * 用一种统一的遍历方式，要求每一个容器都要提供Iterator的实现类
 * 作业：实现LinkedList的Iterator
 *
 * JDK的容器的Iterator
 * @author : Darren
 * @date : 2020年07月29日 14:14:41
 **/
public class Main {

    public static void main(String[] args) {
        Collection list = new ArrayList();
        for (int i = 0; i < 15; i++) {
            list.add(new StringBuilder("s" + i));
        }
        System.out.println(list.size());

        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}


