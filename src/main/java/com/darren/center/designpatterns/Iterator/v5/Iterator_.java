package com.darren.center.designpatterns.Iterator.v5;

/**
 * 让容器自己去实现自己的遍历方式
 */
public interface Iterator_ {

    /**
     * 判断集合是否还有元素
     * @return
     */
    boolean hasNext();

    /**
     * 返回集合的当前元素
     * @return
     */
    Object next();

}
