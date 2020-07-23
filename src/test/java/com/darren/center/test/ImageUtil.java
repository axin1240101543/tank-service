package com.darren.center.test;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <h3>tank-service</h3>
 * <p>加载图片测试类</p>
 *
 * @author : Darren
 * @date : 2020年07月22日 14:47:49
 **/
public class ImageUtil {

    @Test
    public void test() throws IOException {
        //BufferedImage read = ImageIO.read(new File("C:/Users/Darren/Desktop/44b2641b8649f924c7d8841d6d78722f.jpg"));

        BufferedImage read1 = ImageIO.read(ImageUtil.class.getClassLoader().getResourceAsStream("images/1.jpg"));
        BufferedImage read2 = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("images/1.jpg"));
        System.out.println(this.getClass().getClassLoader());
    }


}
