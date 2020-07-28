package com.darren.center.designpatterns.flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <h3>tank-service</h3>
 * <p>享元模式</p>
 *
 * @author : Darren
 * @date : 2020年07月28日 10:39:05
 **/
class Bullet {

    public UUID id = UUID.randomUUID();

    boolean living = true;

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                ", living=" + living +
                '}';
    }
}

/**
 * 子弹池
 */
class BulletPool{

    List<Bullet> bullets = new ArrayList<>();

    {
        for (int i = 0; i < 5; i++) {
            bullets.add(new Bullet());
        }
    }

    public Bullet getBullet(){
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            //如果bullet的living是false，即不是活着的
            if (!bullet.living){
                return bullet;
            }
        }
        return new Bullet();
    }

    public static void main(String[] args) {
        BulletPool bulletPool = new BulletPool();

        for (int i = 0; i < 10; i++) {
            Bullet bullet = bulletPool.getBullet();
            System.out.println(bullet);
        }
    }

}
