package ua.batimyk.generic.list;

/**
 * Created by N on 01/15/16.
 * NVL
 */
public class LinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> last;

    private int size = 0;

    @Override
    public void add(E element) {
        linkLast(element);
    }

    @Override
    public void add(int index, E element) {
        if (index == size) {
            linkLast(element);
        } else if (index == 0) {
            linkFirst(element);
        } else {
            Node<E> node = getNode(index);
            node.prev = new Node<>(node.prev, element, node);
            size++;
        }
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNode(index);
        E oldValue = node.item;
        node.item = element;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        return unlink(getNode(index));
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
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
        for (Node<E> node = first; node != null; ) {
            Node<E> next = node.next;
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
    public E get(int index) {
        return getNode(index).item;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.item == null) {
                    return i;
                }
                node = getNext(node);
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.item)) {
                    return i;
                }
                node = getNext(node);
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        Node<E> node = last;
        if (element == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (node.item == null) {
                    return i;
                }
                node = getPrev(node);
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (element.equals(node.item)) {
                    return i;
                }
                node = getPrev(node);
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    @SuppressWarnings("unchecked")
    private void linkLast(E item) {
        Node<E> node = last;
        Node<E> newNode = new Node(node, item, null);
        last = newNode;
        if (node == null) {
            first = newNode;
        } else {
            node.next = newNode;
        }
        size++;
    }

    @SuppressWarnings("unchecked")
    private void linkFirst(E item) {
        Node<E> node = first;
        Node<E> newNode = new Node(null, item, node);
        first = newNode;
        if (node == null) {
            last = newNode;
        } else {
            node.prev = newNode;
        }
        size++;

    }

    private E unlink(Node<E> node) {
        E oldValue = node.item;
        Node<E> next = node.next;
        Node<E> prev = node.prev;

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

    @SuppressWarnings("unchecked")
    private Node<E> getNext(Node node) {

        return node.next;
    }

    private Node<E> getPrev(Node<E> node) {

        return node.prev;
    }

    private Node<E> getNode(int index) {
        indexCheck(index);
        Node<E> node;
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

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
