package com.darren.center.designpatterns.bridge.v1;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2020年07月30日 10:03:58
 **/
public class Boy {


    public void chase(Girl girl){
        Gift gift = new Book();
        give(girl, gift);
    }

    public void give(Girl girl, Gift gift){

    }

    public static void main(String[] args) {

    }

}
