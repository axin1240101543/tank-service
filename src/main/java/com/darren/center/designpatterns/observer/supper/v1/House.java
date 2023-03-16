package com.darren.center.designpatterns.observer.supper.v1;

/**
 * <h3>demo</h3>
 * <p>房子</p>
 *
 * @author : Darren
 * @date : 2020年11月04日 18:52:51
 **/
public class House {

    /**
     * 房东
     */
    private String owner;

    /**
     * 格局
     */
    private String layout;

    /**
     * 出租金额
     */
    private int money;

    public House(String owner, String layout, int money) {
        this.owner = owner;
        this.layout = layout;
        this.money = money;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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
                "owner='" + owner + '\'' +
                ", layout='" + layout + '\'' +
                ", money=" + money +
                '}';
    }
}
