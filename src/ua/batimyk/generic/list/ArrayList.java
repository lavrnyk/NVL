package ua.batimyk.generic.list;

/**
 * Created by N on 01/11/16.
 * NVL
 */
public class ArrayList<E> implements List<E> {

    private static final int INITIAL_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final float INCREASING_COEFFICIENT = 1.5f;

    private int capacity = INITIAL_CAPACITY;

    @SuppressWarnings("unchecked")
    private E[] elements = (E[]) new Object[capacity];
    private int size = 0;

    @Override
    public void add(E element) {
        checkCapacity(size + 1);
        elements[size] = element;
        size++;
    }

    @Override
    public void add(int index, E element) {
        indexAddCheck(index);
        checkCapacity(index);
        size++;

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
    }

    @Override
    public E set(int index, E element) {
        indexCheck(index);
        E elementOld = elements[index];
        elements[index] = element;
        return elementOld;
    }

    @Override
    public E remove(int index) {
        indexCheck(index);
        E elementOld = elements[index];
        resizeAndRemove(index);
        return elementOld;
    }

    @Override
    public boolean remove(E element) {
        int index = indexOf(element);
        if (index >= 0) {
            resizeAndRemove(index);
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
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        if (element == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    private void indexCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void indexAddCheck(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @SuppressWarnings("unchecked")
    private void increase() {

        this.capacity *= INCREASING_COEFFICIENT;
        E[] newElements = (E[]) new Object[this.capacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }

    private void checkCapacity(int capacity) {
        if (capacity > MAX_ARRAY_SIZE) {
            throw new OutOfMemoryError();
        }
        if (capacity >= elements.length) {
            increase();
        }
    }

    @SuppressWarnings("unchecked")
    private void resizeAndRemove(int index) {

        E[] newElements = (E[]) new Object[size - 1];
        System.arraycopy(elements, index + 1, newElements, index, size - 1 - index);
        size--;
        elements = newElements;
    }

    public static void main(String[] args) {
        ArrayList<Long> list = new ArrayList<>();
        list.add(1234L);
        long l = list.get(0);

        System.out.println(l);
    }

}
