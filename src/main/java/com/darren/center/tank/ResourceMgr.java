package com.darren.center.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <h3>tank-service</h3>
 * <p>加载图片</p>
 *
 * @author : Darren
 * @date : 2020年07月22日 15:38:08
 **/
public class ResourceMgr {

    private static final ResourceMgr resource;

    private ResourceMgr() {
    }

    public BufferedImage goodTankU, goodTankD, goodTankL, goodTankR;
    public BufferedImage badTankU, badTankD, badTankL, badTankR;
    public BufferedImage bulletU, bulletD, bulletL, bulletR;
    public BufferedImage[] explodes;

    static {
        resource = new ResourceMgr();
        resource.explodes = new BufferedImage[16];
        try {
            //坦克的四个方向
            resource.goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            resource.goodTankL = ImageUtil.rotateImage(resource.goodTankU, -90);
            resource.goodTankR = ImageUtil.rotateImage(resource.goodTankU, 90);
            resource.goodTankD = ImageUtil.rotateImage(resource.goodTankU, 180);

            resource.badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            resource.badTankL = ImageUtil.rotateImage(resource.badTankU, -90);
            resource.badTankR = ImageUtil.rotateImage(resource.badTankU, 90);
            resource.badTankD = ImageUtil.rotateImage(resource.badTankU, 180);

            //子弹的四个方向
            resource.bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            resource.bulletL = ImageUtil.rotateImage(resource.bulletU, -90);
            resource.bulletR = ImageUtil.rotateImage(resource.bulletU, 90);
            resource.bulletD = ImageUtil.rotateImage(resource.bulletU, 180);

            //加入爆炸
            for (int i = 0; i < 16; i++) {
                resource.explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ResourceMgr getInstance(){
        return resource;
    }

}
