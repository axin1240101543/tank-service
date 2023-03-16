package com.darren.center.designpatterns.observer.supper.v2;

/**
 * <h3>demo</h3>
 * <p>房子</p>
 *
 * @author : Darren
 * @date : 2020年11月04日 18:30:51
 **/
public class House {

    /**
     * 格局
     */
    private String layout;

    /**
     * 出租金额
     */
    private int money;

    public House(String layout, int money) {
        this.layout = layout;
        this.money = money;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "House{" +
                "layout='" + layout + '\'' +
                ", money=" + money +
                '}';
    }
}
