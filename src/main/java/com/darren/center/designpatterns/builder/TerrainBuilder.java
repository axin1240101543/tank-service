package com.darren.center.designpatterns.builder;

/**
 * <h3>tank-service</h3>
 *
 * @author : Darren
 * @date : 2020年07月30日 09:16:41
 **/
public interface TerrainBuilder {

    TerrainBuilder buildWall();

    TerrainBuilder buildFort();

    TerrainBuilder buildMine();

    Terrain build();

}
