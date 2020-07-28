package com.darren.center.designpatterns.flyweight;

/**
 * <h3>tank-service</h3>
 * <p>字符串常量池</p>
 *
 * @author : Darren
 * @date : 2020年07月28日 10:47:43
 **/
public class TestString {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";

        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s3 == s4);

        System.out.println(s3.intern() == s1);

        System.out.println(s3.intern() == s4.intern());
    }

}
