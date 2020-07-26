package com.darren.center.tank.decorator;

import com.darren.center.tank.GameObject;

import java.awt.*;

/**
 * <h3>tank-service</h3>
 * <p>方框装饰器</p>
 *
 * @author : Darren
 * @date : 2020年07月26日 19:34:22
 **/
public class RectDecorator extends GODecorator{

    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        //方框要跟着子弹的坐标进行改变
        this.x = go.x;
        this.y = go.y;

        go.paint(g);

        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawRect(super.go.x, super.go.y, super.go.getWidth() + 2, super.go.getHeight() + 2);
        g.setColor(color);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}
