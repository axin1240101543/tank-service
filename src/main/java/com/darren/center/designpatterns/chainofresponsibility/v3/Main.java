package com.darren.center.designpatterns.chainofresponsibility.v3;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>tank-service</h3>
 * <p>责任链模式</p>
 *
 * 设计模式倒数第二难的一种，第一是proxy
 *
 * v2:将变化的内容抽象出来
 * v3:将两个filter串联起来
 *
 * @author : Darren
 * @date : 2020年07月29日 20:17:48
 **/
public class Main {

    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ");

        List<Filter> filters = new ArrayList<>();
        filters.add(new HTMLFilter());
        filters.add(new SensitiveFilter());

        for (Filter filter : filters) {
            filter.doFilter(msg);
        }

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

    void doFilter(Msg g);

}

class HTMLFilter implements Filter {

    @Override
    public void doFilter(Msg g) {
        String msg1 = g.getMsg();
        msg1 = msg1.replace("<", "[");
        msg1 = msg1.replace(">", "]");
        g.setMsg(msg1);
    }
}

class SensitiveFilter implements Filter {

    @Override
    public void doFilter(Msg g) {
        String msg1 = g.getMsg();
        msg1 = msg1.replace("996", "955");
        g.setMsg(msg1);
    }
}

