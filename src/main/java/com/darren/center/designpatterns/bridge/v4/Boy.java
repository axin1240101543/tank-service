package com.darren.center.designpatterns.bridge.v4;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * 如果礼物分为温柔的礼物和狂野的礼物
 * WarmGift WildGift
 * 这时Flower应该分为
 * WarmFlower WildFlower
 * WarmBook WildBook
 *
 * 如果再有别的礼物，比如抽象类型：ToughGift ColdGift
 * 或者具体的某种实现：Ring Car
 *
 * 就会产生类的爆炸
 * WarmCar ColdRing WildCar WildFlower ...
 *
 * 使用桥接模式：
 * 分离抽象与具体实现，让他们可以独自发展
 * Gift -> WarmGift ColdGift WildGift
 * GiftImpl -> Flower Ring Car
 *
 * @author : Darren
 * @date : 2020年07月30日 10:03:58
 **/
public class Boy {


    public void chase(Girl girl){
        Gift gift = new WarmGift(new Flower());
        give(girl, gift);
    }

    public void give(Girl girl, Gift gift){
        System.out.println(girl + " gived " + gift);
    }

    public static void main(String[] args) {
        new Boy().chase(new Girl("fairy"));
    }

}
