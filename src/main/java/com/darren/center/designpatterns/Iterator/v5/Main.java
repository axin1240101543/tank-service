package com.darren.center.designpatterns.Iterator.v5;

/**
 * <h3>tank-service</h3>
 * <p>迭代器设计模式</p>
 *
 * 如何对容器遍历呢？
 * 用一种统一的遍历方式，要求每一个容器都要提供Iterator的实现类
 * 作业：实现LinkedList的Iterator
 *
 * https://blog.csdn.net/u010501127/article/details/9004202
 *
 * @author : Darren
 * @date : 2020年07月29日 14:14:41
 **/
public class Main {

    public static void main(String[] args) {
        Collection_ list = new LinkedList_();
        for (int i = 0; i < 15; i++) {
            list.add(new StringBuilder("s" + i));
        }
        System.out.println(list.size());

        Iterator_ iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}


