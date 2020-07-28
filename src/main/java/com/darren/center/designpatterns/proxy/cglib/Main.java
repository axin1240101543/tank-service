package com.darren.center.designpatterns.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Random;

/**
 * <h3>tank-service</h3>
 * <p>CGLIB实现动态代理不需要接口</p>
 *
 * @author : Darren
 * @date : 2020年07月28日 14:37:51
 **/
public class Main {

    /**
     * 报错：IncompatibleClassChangeError: class net.sf.cglib.core.DebuggingClassWriter has interface org.objectw
     *
     * https://stackoverflow.com/questions/12449074/spring-framework-java-lang-incompatibleclasschangeerror-class-net-sf-cglib-co
     *
     * +1, just to add on - the specific version of CGLIB compatible with Spring 3.1.2 is cglib 2.2.2 , asm 3.3.1, removing cglib-3.0 should just do it.
     * @param args
     */
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Tank tank = (Tank) enhancer.create();
        tank.move();
    }

}

class TimeMethodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(o.getClass().getSuperclass().getName());
        System.out.println("start moving……");
        Object result = null;
        result = methodProxy.invokeSuper(o, objects);
        System.out.println("start stopped!!!");
        return result;
    }
}

/**
 * 被代理类
 */
class Tank{
    public void move() {
        System.out.println("tank moving ……");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
