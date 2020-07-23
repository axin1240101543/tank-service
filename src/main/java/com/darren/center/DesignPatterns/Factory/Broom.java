package com.darren.center.DesignPatterns.Factory;

/**
 * <h3>tank-service</h3>
 * <p>扫帚</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 16:46:18
 **/
public class Broom implements Removeable{

    @Override
    public void go() {
        System.out.println("Broom …………");
    }
}
