package com.darren.center.designpatterns.Iterator.v7;

/**
 * <h3>tank-service</h3>
 * <p>数组的实现</p>
 *
 * @author : Darren
 * @date : 2020年07月29日 14:36:06
 **/
public class ArrayList_<E> implements Collection_<E> {

    E[] objects = (E[]) new Object[10];

    //objects中下一个空的位置在哪儿,或者说，目前容器中有多少个元素
    private int index = 0;

    @Override
    public void add(E o){
        //如果达到最大容量10
        if (index == objects.length){
            //扩容两倍
            E[] newObjects = (E[]) new Object[objects.length*2];
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

    @Override
    public Iterator_<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator<E> implements Iterator_<E>{

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if (currentIndex >=index){
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            E object = (E) objects[currentIndex];
            currentIndex++;
            return object;
        }
    }
}
