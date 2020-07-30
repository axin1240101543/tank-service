package com.darren.center.designpatterns.prototype.v1;

/**
 * <h3>tank-service</h3>
 * <p>原型模式</p>
 *
 * 浅克隆
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
        System.out.println(person);
        System.out.println(person2);

        System.out.println(person.loc == person2.loc);

        person.loc.street= "beijing";
        System.out.println(person2.loc.street);
    }

}


class Person implements Cloneable{

    int age = 8;
    int score = 100;

    Location loc = new Location("shenzhen", 101);

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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

class Location{

    String street;

    int roomNo;

    public Location(String street, int roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    @Override
    public String toString() {
        return "Location{" +
                "street='" + street + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }
}
