package ua.batimyk.list;

/**
 * Created by mbatitskiy on 29-Dec-15.
 */
public class LinkedList implements List {

    Node first;
    Node last;

    private int size = 0;

    @Override
    public void add(Object value) {
        linkLast(value);
    }

    @Override
    public void add(int index, Object value) {

    }

    @Override
    public Object set(int index, Object value) {
        return null;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public boolean remove(Object value) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object value) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        return 0;
    }

    @Override
    public boolean contains(Object value) {
        return false;
    }

    void linkLast(Object item) {
        final Node node = last;
        final Node newNode = new Node(node,item,null);
        last = newNode;
        if (node == null) {
            first = newNode;
        } else{
            node.next = newNode;
        }
       size++;
    }

    public static class Node {
        Object item;
        Node next;
        Node prev;

        Node(Node prev, Object item, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
