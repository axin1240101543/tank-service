package com.darren.center.designpatterns.proxy.spring.v2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * <h3>tank-service</h3>
 * <p>代理类</p>
 *
 * @author : Darren
 * @date : 2020年07月28日 15:01:03
 **/
@Aspect
public class TimeProxy {

    @Before("execution(void com.darren.center.designpatterns.proxy.spring.v2.Tank.move())")
    public void before(){
        System.out.println("start moving……");
    }

    @After("execution(void com.darren.center.designpatterns.proxy.spring.v2.Tank.move())")
    public void after(){
        System.out.println("start stopped!!!");
    }

}
