package ua.com.omiftakhov.arraysManipulationAndCo;

/**
 * Created by omiftakhov on 28.12.2015.
 */
public class LinkedList implements List {

    Node first;
    Node last;
    int size;

    @Override
    public void add(Object value) {
        if (size == 0) {
            Node node = new Node(value);
            first = last = node;
        }
        {
            Node node = new Node(value);
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
    }

    @Override
    public void add(int index, Object value) {
        if (index != size) {
            validateIndex(index);
        }
        if (index == size) {
            add(value);
        } else {
            Node curNode = findNode(index);
            Node newNode = new Node(value);
            if (curNode.prev == null) {
                first = newNode;
            } else {
                curNode.prev.next = newNode;
            }
            curNode.prev = newNode;
        }
        size++;
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        return findNode(index).value;
    }

    @Override
    public Object set(int index, Object value) {
        validateIndex(index);
        findNode(index).value = value;
        return value;

    }

    @Override
    public Object remove(int index) {
        validateIndex(index);
        Node node = findNode(index);
        if (node.prev == null) {
            first = node.next;
        } else {
            node.prev.next = node.next;
            node.prev = null;
        }

        if (node.next == null) {
            last = node.prev;
        } else {
            node.next.prev = node.prev;
            node.next = null;
        }

        node.value = null;
        size--;
        return node;
    }

    @Override
    public void clear() {
        Node curNode = first;
        for (int i = 0; i < size; i++) {
            curNode = curNode.next;
            curNode.value = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public int indexOf(Object value) {
        Node curNode = first;
        for (int i = 0; i < size; i++) {
            curNode = curNode.next;
            if (curNode.value == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node curNode = last;
        for (int i = size - 1; i >= 0; i--) {
            if (curNode.value == value) {
                return i;
            }
            curNode = curNode.prev;
        }
        return -1;
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) == -1 ? false : true;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            String message = "Index = " + index + "," + "should be between 0 and " + size;
            throw new IndexOutOfBoundsException(message);
        }
    }

    private Node findNode(int index) {
        if (index < (size / 2)) {
            Node curNode = first;
            for (int i = 0; i < index; i++)
                curNode = curNode.next;
            return curNode;
        } else {
            Node curNode = last;
            for (int i = size - 1; i > index; i--)
                curNode = curNode.prev;
            return curNode;
        }
    }

    private static class Node {
        Object value;
        Node next;
        Node prev;

        Node(Object value) {
            this.value = value;
        }
    }
}