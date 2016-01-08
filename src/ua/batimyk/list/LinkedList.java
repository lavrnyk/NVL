package ua.batimyk.list;

/**
 * Created by mbatitskiy on 29-Dec-15.
 */
public class LinkedList implements List {

    private Node first;
    private Node last;

    private int size = 0;

    @Override
    public void add(Object value) {

        linkLast(value);
    }

    @Override
    public void add(int index, Object value) {
        if (index == size) {
            linkLast(value);
        } else if (index == 0) {
            linkFirst(value);
        } else {
            Node node = getNode(index);
            node.prev = new Node(node.prev, value, node);
            size++;
        }
    }

    @Override
    public Object set(int index, Object value) {
        Node node = getNode(index);
        Object oldValue = node.item;
        node.item = value;
        return oldValue;
    }

    @Override
    public Object remove(int index) {
        indexCheck(index);
        Node node = getNode(index);
        Object oldValue = node.item;
        if (index == 0) {
            first = node.next;
        } else if (index == size - 1) {
            last = node.prev;
        } else {

            Node next = node.next;
            Node prev = node.prev;
            next.prev = prev.next;
        }

        node.item = null;
        node.next = null;
        node.prev = null;

        size--;
        return oldValue;
    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);
        if(index >= 0) {
           remove(index);
           return true;
        }
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
        for (Node node = first; node != null; ) {
            Node next = node.next;
            node.item = null;
            node.next = null;
            node.prev = null;
            node = next;
        }
        first = null;
        last = null;
        size = 0;

    }

    @Override
    public Object get(int index) {
        return getNode(index).item;
    }

    @Override
    public int indexOf(Object value) {
        Node node = first;
        if (value == null) {
            for (int i = 0 ; i < size; i++) {
                if (node.item == null) {
                    return i;
                }
                node = node.next;
            }
        } else
        {
            for (int i = 0 ; i < size ; i++) {
                if(value.equals(node.item)) {
                    return i;
                }
                node = node.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node node = last;
        if (value == null) {
            for (int i = size - 1 ; i >= 0; i--) {
                if (node.item == null) {
                    return i;
                }
                node = node.prev;
            }
        } else
        {
            for (int i = size - 1 ; i >= 0; i--) {
                if(value.equals(node.item)) {
                    return i;
                }
                node = node.prev;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) >= 0;
    }

    private void linkLast(Object item) {
        Node node = last;
        Node newNode = new Node(node, item, null);
        last = newNode;
        if (node == null) {
            first = newNode;
        } else {
            node.next = newNode;
        }
        size++;
    }

    private void linkFirst(Object item) {
        Node node = first;
        Node newNode = new Node(null, item, node);
        first = newNode;
        if (node == null) {
            last = newNode;
        } else {
            node.prev = newNode;
        }
        size++;

    }

    private void indexCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean hasNext(Node node) {
        return !(node == last || node == null);
    }

    private Node getNext(Node node) {
        return node.next;
    }

    private Node getPrev(Node node) {
        return node.prev;
    }

    private Node getNode(int index) {
        indexCheck(index);
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = getNext(node);
        }
        return node;
    }

    private static class Node {
        Object item;
        Node next;
        Node prev;

        Node(Node prev, Object item, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(0, "a1");
        list.add(1, "a2");
        list.add(2, "a3");
        list.add(3, "a2");
        list.add(4, "aaaa");
        list.add(5, 1000L);

        // System.out.println(list.get(list.size() - 1));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
