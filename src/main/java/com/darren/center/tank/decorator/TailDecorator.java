package com.darren.center.tank.decorator;

import com.darren.center.tank.GameObject;

import java.awt.*;

/**
 * <h3>tank-service</h3>
 * <p>尾巴装饰器</p>
 *
 * @author : Darren
 * @date : 2020年07月26日 19:43:35
 **/
public class TailDecorator extends GODecorator{

    public TailDecorator(GameObject go) {
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
        g.drawLine(go.x, go.y, go.x + getWidth(), go.y + getHeight());
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
