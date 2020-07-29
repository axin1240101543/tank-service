package com.darren.center.designpatterns.proxy.spring.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <h3>tank-service</h3>
 * <p>Spring AOP</p>
 *
 * @author : Darren
 * @date : 2020年07月28日 14:59:59
 **/
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("app_auto.xml");
        Tank tank = (Tank) applicationContext.getBean("tank");
        tank.move();
    }

}
