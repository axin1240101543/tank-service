package com.darren.center.designpatterns.Iterator.v2;

/**
 * <h3>tank-service</h3>
 * <p>迭代器设计模式</p>
 *
 * 用链表来实现一个容器
 * @author : Darren
 * @date : 2020年07月29日 14:14:41
 **/
public class Main {

    public static void main(String[] args) {
        LinkedList_ list = new LinkedList_();
        for (int i = 0; i < 15; i++) {
            list.add(new StringBuilder("s" + i));
        }
        System.out.println(list.size());
    }

}

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
class LinkedList_{

    Node head = null;
    Node tail = null;

    //目前容器中有多少个元素
    private int size = 0;

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

    public int size(){
        return size;
    }
}


