package com.darren.center.designpatterns.chainofresponsibility.v1;

/**
 * <h3>tank-service</h3>
 * <p>责任链模式</p>
 *
 * 设计模式倒数第二难的一种，第一是proxy
 *
 * @author : Darren
 * @date : 2020年07月29日 20:17:48
 **/
public class Main {

    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:)，<script>，欢迎访问 mashibing.com ，大家都是996 ");

        //处理msg
        String msg1 = msg.getMsg();
        msg1 = msg1.replace("<", "[");
        msg1 = msg1.replace(">", "]");
        msg.setMsg(msg1);

        msg1 = msg1.replace("996", "955");
        msg.setMsg(msg1);

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
