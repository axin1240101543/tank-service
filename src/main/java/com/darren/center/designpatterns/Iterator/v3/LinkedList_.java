package com.darren.center.designpatterns.Iterator.v3;

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
public class LinkedList_ implements Collection_{

    Node head = null;
    Node tail = null;

    //目前容器中有多少个元素
    private int size = 0;

    @Override
    public void add(Object o){
        Node n = new Node(o);
        n.next = null;

        if (head == null){
            //表头和表尾都是n
            head = n;
            tail = n;
        }else {
            //之前的表尾指向n
            tail.next = n;
            //新表尾变成n
            tail = n;
        }

        size++;
    }

    private class Node{
        private Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

    @Override
    public int size(){
        return size;
    }
}


