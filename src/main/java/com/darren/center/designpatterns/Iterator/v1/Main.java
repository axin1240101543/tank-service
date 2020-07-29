package com.darren.center.designpatterns.Iterator.v1;

/**
 * <h3>tank-service</h3>
 * <p>迭代器设计模式</p>
 *
 * 构建一个容器，可以添加对象
 * 用数组来实现一个容器
 *
 * @author : Darren
 * @date : 2020年07月29日 14:14:41
 **/
public class Main {

    public static void main(String[] args) {
        ArrayList_ list = new ArrayList_();
        for (int i = 0; i < 15; i++) {
            list.add(new StringBuilder("s" + i));
        }
        System.out.println(list.size());
    }

}

class ArrayList_{

    Object[] objects = new Object[10];

    //objects中下一个空的位置在哪儿,或者说，目前容器中有多少个元素
    private int index = 0;

    public void add(Object o){
        //如果达到最大容量10
        if (index == objects.length){
            //扩容两倍
            Object[] newObjects = new Object[objects.length*2];
            //将旧数组的内容copy到新数组
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index] = o;
        index++;
    }

    public int size(){
        return index;
    }
}

