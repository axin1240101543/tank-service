package com.darren.center.designpatterns.Iterator.v3;

/**
 * <h3>tank-service</h3>
 * <p>迭代器设计模式</p>
 *
 * 添加容器的共同接口，实现容器的替换
 * @author : Darren
 * @date : 2020年07月29日 14:14:41
 **/
public class Main {

    public static void main(String[] args) {
        Collection_ list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add(new StringBuilder("s" + i));
        }
        System.out.println(list.size());
    }

}


