package com.darren.center.designpatterns.observer.supper.v2;

/**
 * <h3>demo</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2020年11月04日 19:06:39
 **/
public class Test {

    public static void main(String[] args) {
        Tenant xiaoMing = new XiaoMing();
        xiaoMing.requireHouse();
        Tenant xiaoZhang = new XiaoZhang();
        xiaoZhang.requireHouse();
    }

}
