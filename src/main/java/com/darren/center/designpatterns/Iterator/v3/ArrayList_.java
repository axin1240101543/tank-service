package com.darren.center.designpatterns.Iterator.v3;

/**
 * <h3>tank-service</h3>
 * <p>数组的实现</p>
 *
 * @author : Darren
 * @date : 2020年07月29日 14:36:06
 **/
public class ArrayList_ implements Collection_{

    Object[] objects = new Object[10];

    //objects中下一个空的位置在哪儿,或者说，目前容器中有多少个元素
    private int index = 0;

    @Override
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

    @Override
    public int size(){
        return index;
    }

}
