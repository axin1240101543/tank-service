package com.darren.center.designpatterns.chainofresponsibility.v8;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>tank-service</h3>
 * <p>责任链模式</p>
 *
 * 设计模式倒数第二难的一种，第一是proxy
 *
 * v2:将变化的内容抽象出来
 * v3:将两个Filter串联起来
 * v4:使用FilterChain
 * v5:链式编程  add方法返回FilterChain
 * v6:想将两个FilterChain连起来怎么做？
 * v7:FilterChain也实现Filter接口，将第二个FilterChain当做一个Filter添加到第一个FilterChain中
 * 新问题：
 * FilterChain中的某一个Filter决定链条是否继续
 * v8:Filter添加返回值
 *
 * @author : Darren
 * @date : 2020年07月29日 20:17:48
 **/
public class Main {

    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ");

        FilterChain filterChain = new FilterChain();
        //链式编程
        filterChain.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter());

        FilterChain filterChain2 = new FilterChain();
        filterChain2.addFilter(new FaceFilter())
                .addFilter(new URLFilter());

        filterChain.addFilter(filterChain2);
        filterChain.doFilter(msg);

        System.out.println(msg);
    }

}

class Msg{

    String name;

    String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

interface Filter{

    /**
     * 返回true继续往下运行，返回false就不往下继续运行了
     * @param g
     * @return
     */
    boolean doFilter(Msg g);

}

class HTMLFilter implements Filter {

    @Override
    public boolean doFilter(Msg g) {
        String msg1 = g.getMsg();
        msg1 = msg1.replace("<", "[");
        msg1 = msg1.replace(">", "]");
        g.setMsg(msg1);
        return true;
    }
}

class SensitiveFilter implements Filter {

    @Override
    public boolean doFilter(Msg g) {
        String msg1 = g.getMsg();
        msg1 = msg1.replace("996", "955");
        g.setMsg(msg1);
        return true;
    }
}

class FaceFilter implements Filter {

    @Override
    public boolean doFilter(Msg g) {
        String msg1 = g.getMsg();
        msg1 = msg1.replace(":)", "^V^");
        g.setMsg(msg1);
        return false;
    }
}

class URLFilter implements Filter {

    @Override
    public boolean doFilter(Msg g) {
        String msg1 = g.getMsg();
        msg1 = msg1.replace("mashibing.com", "http://www.mashibing.com");
        g.setMsg(msg1);
        return true;
    }
}

class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    public FilterChain addFilter(Filter filter){
        filters.add(filter);
        return this;
    }

    public boolean doFilter(Msg msg){
        for (Filter filter : filters) {
            if (!filter.doFilter(msg)){
                return false;
            }
        }
        return true;
    }
}

