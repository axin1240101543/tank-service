package com.darren.center.designpatterns.builder;

/**
 * <h3>tank-service</h3>
 * <p>Builder设计模式</p>
 *
 * @author : Darren
 * @date : 2020年07月30日 09:21:53
 **/
public class Main {

    public static void main(String[] args) {
        TerrainBuilder terrainBuilder = new ComplexTerrainBuilder();
        Terrain build = terrainBuilder.buildFort().buildMine().buildWall().build();
        System.out.println(build);

        Person person = new Person.PersonBuilder()
                .basicInfo(1, "zhangsan", 18)
                //.score(20)
                .weight(200)
                //.loc("bj", "23")
                .build();
        System.out.println(person);
    }

}
