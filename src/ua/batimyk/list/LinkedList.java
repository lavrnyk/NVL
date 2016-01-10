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
        return unlink(getNode(index));
    }

    @Override
    public boolean remove(Object value) {
        int index = indexOf(value);
        if (index >= 0) {
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
            for (int i = 0; i < size; i++) {
                if (node.item == null) {
                    return i;
                }
                node = getNext(node);
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (value.equals(node.item)) {
                    return i;
                }
                node = getNext(node);
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node node = last;
        if (value == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (node.item == null) {
                    return i;
                }
                node = getPrev(node);
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (value.equals(node.item)) {
                    return i;
                }
                node = getPrev(node);
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

    private Object unlink(Node node) {
        Object oldValue = node.item;
        Node next = node.next;
        Node prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
        size--;

        return oldValue;
    }


    private void indexCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private Node getNext(Node node) {

        return node.next;
    }

    private Node getPrev(Node node) {

        return node.prev;
    }

    private Node getNode(int index) {
        indexCheck(index);
        Node node;
        if (index < (size / 2)) {
            node = first;
            for (int i = 0; i < index; i++) {
                node = getNext(node);
            }
        } else {
            node = last;
            for (int i = size - 1; i > index; i--) {
                node = getPrev(node);
            }
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
}
