package com.darren.center.designpatterns.builder;

/**
 * <h3>tank-service</h3>
 * <p></p>
 *
 * @author : Darren
 * @date : 2020年07月30日 09:26:51
 **/
public class Person {

    int id;

    String name;

    int age;

    double weight;

    int score;

    Location loc;

    private Person() {
    }

    public static class PersonBuilder{
        Person person = new Person();

        public PersonBuilder basicInfo(int id, String name, int age){
            person.id = id;
            person.name = name;
            person.age = age;
            return this;
        }

        public PersonBuilder weight(double weight){
            person.weight = weight;
            return this;
        }

        public PersonBuilder score(int score){
            person.score = score;
            return this;
        }

        public PersonBuilder loc(String street, String roomNo){
            person.loc = new Location(street, roomNo);
            return this;
        }

        public Person build(){
            return person;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", score=" + score +
                ", loc=" + loc +
                '}';
    }
}

class Location{

    String street;

    String roomNo;

    public Location(String street, String roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }
}
