package com.company;

public class Person {
    int id;
    String name;
    Phone phone;
    double salary;
    int age;

    public Person(int id) {
        this.id = id;
    }

    public Person(int id, String name, Phone phone, double salary, int age) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public Person() {

    }

    public String toString() {
        return "id = " + id + " name = " + name;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Person) {
            Person person = (Person) obj;
            if (id != person.id) {
                return false;
            }
            if(name == null){
                return person.name == null;
            }else {
                return name.equals(person.name);
            }
        }

        return false;
    }

}
