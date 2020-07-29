package com.darren.center.designpatterns.Iterator.v7;

/**
 * 相比数组，这个容器不用考虑边界问题，可以动态扩展
 */
public class LinkedList_<E> implements Collection_<E> {

    //表头
    Node head = null;
    //表尾
    Node tail = null;

    //目前容器中有多少个元素
    private int size = 0;

    @Override
    public void add(E o){
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
        //每添加一个节点,链表的大小自增一次
        size++;
    }

    private class Node{
        //存储自身的元素
        private E o;
        //下一个节点的引用
        Node next;

        public Node(E o) {
            this.o = o;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "o=" + o +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public Iterator_<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator<E> implements Iterator_<E> {

        //定义一个变量指向当前迭代的节点,初始值是表头
        Node current = head;

        @Override
        public boolean hasNext() {
            // 判断当前节点是否为空,部位空的话表面链表还有未迭代的节点,返回true
            return current != null;
        }

        @Override
        public E next() {
            //获得当前节点的内容
            E o = (E) current.o;
            //使指针指向下一个节点
            current = current.next;
            return o;
        }
    }
}


