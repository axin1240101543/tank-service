package com.darren.center.designpatterns.asm.v3;

/**
 * <h3>tank-service</h3>
 * <p>自定义类加载器</p>
 *
 * @author : Darren
 * @date : 2020年07月29日 19:25:26
 **/
public class MyClassLoader extends ClassLoader{

    protected Class defineClass(String name, byte[] b){
        return defineClass(name, b, 0, b.length);
    }
}
