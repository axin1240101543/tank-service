package com.darren.center.designpatterns.builder;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2020年07月30日 09:22:51
 **/
public class ComplexTerrainBuilder implements TerrainBuilder{

    Terrain terrain = new Terrain();

    @Override
    public TerrainBuilder buildWall() {
        terrain.wall = new Wall(10, 10, 50, 50);
        return this;
    }

    @Override
    public TerrainBuilder buildFort() {
        terrain.fort = new Fort(10, 10, 50, 50);
        return this;
    }

    @Override
    public TerrainBuilder buildMine() {
        terrain.mine = new Mine(10, 10, 50, 50);
        return this;
    }

    @Override
    public Terrain build() {
        return terrain;
    }
}
