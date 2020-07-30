package com.darren.center.designpatterns.prototype.v3;

/**
 * <h3>tank-service</h3>
 * <p>原型模式</p>
 *
 * String需要进一步深克隆吗？
 *
 * @author : Darren
 * @date : 2020年07月30日 11:16:08
 **/
public class Main {

    /**
     * 浅克隆：克隆对象的引用对象指向的是同一个引用
     * 深克隆：克隆对象的引用对象指向的是一个新引用
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        Person person2 = (Person) person.clone();
        System.out.println("person1：" + person);
        System.out.println("person2：" + person2);

        System.out.println(person.loc == person2.loc);

        person.loc.street= "beijing";
        System.out.println("person1：" + person);
        System.out.println("person2：" + person2);

        person.loc.street.replace("beijing", "shanghai");
        System.out.println("person1：" + person);
        System.out.println("person2：" + person2);
    }

}


class Person implements Cloneable{

    int age = 8;
    int score = 100;

    Location loc = new Location("shenzhen", 101);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.loc = (Location) loc.clone();
        return person;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", score=" + score +
                ", loc=" + loc +
                '}';
    }
}

class Location implements Cloneable{

    String street;

    int roomNo;

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }
}
