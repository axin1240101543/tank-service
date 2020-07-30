package com.darren.center.designpatterns.builder;

/**
 * <h3>tank-service</h3>
 * <p>地形</p>
 *
 * @author : Darren
 * @date : 2020年07月30日 09:18:36
 **/
public class Terrain {

    Wall wall;
    Fort fort;
    Mine mine;

    @Override
    public String toString() {
        return "Terrain{" +
                "wall=" + wall +
                ", fort=" + fort +
                ", mine=" + mine +
                '}';
    }
}

/**
 * 墙
 */
class Wall{

    int x, y, w, h;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }
}

/**
 * 堡垒
 */
class Fort{

    int x, y, w, h;

    public Fort(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Fort{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }

}

/**
 * 地雷
 */
class Mine{

    int x, y, w, h;

    public Mine(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    @Override
    public String toString() {
        return "Mine{" +
                "x=" + x +
                ", y=" + y +
                ", w=" + w +
                ", h=" + h +
                '}';
    }

}
