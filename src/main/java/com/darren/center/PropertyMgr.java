package com.darren.center;

import java.io.IOException;
import java.util.Properties;

/**
 * <h3>tank-service</h3>
 * <p>配置文件加载类</p>
 *
 * @author : Darren
 * @date : 2020年07月23日 09:23:17
 **/
public class PropertyMgr {

    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        };
    }

    public static Object get(String key){
        if (props == null) return null;
        return props.get(key);
    }

    public static void main(String[] args) {
        System.out.println(props.get("initTankCount"));
    }

}
