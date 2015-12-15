package com.company;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(10);
        list.add(20);
        System.out.println(list);
        list.set(1,30);
        System.out.println(list);
        list.add(30);
        list.add(25);
        System.out.println(list);
        System.out.println(list.indexOf(30));
        System.out.println(list.lastIndexOf(30));
        System.out.println(list.size);
        list.remove(1);
        System.out.println(list.size);
        System.out.println(list);
        list.add(25);
        list.add(125);
        list.add(125);
        System.out.println(list.array.length);
        System.out.println(list.size);
        System.out.println(list);
        list.add(3,13);
        System.out.println(list);
        System.out.println(list.array.length);
        System.out.println(list.size);
    }
}
