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

    private static volatile Properties props;

    private PropertyMgr() {
    }

    public static Object getObj(String key){
        if (props == null){
            synchronized (PropertyMgr.class){
                if (props == null){
                    try {
                        props = new Properties();
                        props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return props.get(key);
    }

    public static int getInt(String key){
        return Integer.valueOf(getObj(key).toString());
    }

    public static String getStr(String key){
        return getObj(key).toString();
    }

    public static void main(String[] args) {
        System.out.println(PropertyMgr.getObj("initTankCount"));
        System.out.println(PropertyMgr.getInt("initTankCount"));
    }

}
