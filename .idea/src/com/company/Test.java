package com.company;

public class Test {
    public static void main(String[] args) {
        Phone firstPhone = new Phone(555, "123-22-11");
        Phone secondPhone = new Phone(555, "123-22-11");
        Person p = new Person(10, "Vasya", firstPhone, 1000, 25);
        Person p1 = new Person(10, "Vasya", secondPhone, 1000, 25);

        System.out.println(p.equals(null)); // false
        System.out.println(p.equals("asd")); // false
        System.out.println(p.equals(p1)); // true

        p = new Person(10, "Vasya", null, 1000, 25);
        p1 = new Person(10, "Vasya", null, 1000, 25);

        System.out.println(p.equals(null)); // false
        System.out.println(p.equals("asd")); // false
        System.out.println(p.equals(p1)); // true

        p = new Person(10, "Vasya", null, 1000, 25);
        p1 = new Person(10, "Vasya", firstPhone, 1000, 25);

        System.out.println(p.equals(null)); // false
        System.out.println(p.equals("asd")); // false
        System.out.println(p.equals(p1)); // false
    }
}
