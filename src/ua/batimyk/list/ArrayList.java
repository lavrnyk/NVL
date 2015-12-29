package ua.batimyk.list;

/**
 * Created by mbatitskiy on 24-Dec-15.
 */
public class ArrayList implements List {

    private int size = 0;
    private static final int INITIAL_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final float INCREASING_COEFFICIENT = 1.5f;

    protected int capacity = INITIAL_CAPACITY;

    Object[] elements = new Object[capacity];

    public void add(Object value) {
        //rangeCheck(size);
        checkCapacity(size + 1);
        elements[size] = value;
        size++;
    }

    public void add(int index, Object value) {
        // rangeCheck(size);
        checkCapacity(index);
        size++;

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = value;
    }

    public Object set(int index, Object value) {
        rangeCheck(index);
        Object elementOld = elements[index];
        elements[index] = value;
        return elementOld;
    }

    public boolean remove(Object value) {
        int index = indexOf(value);
        if (index >= 0) {
            resizeAndRemove(index);
            return true;
        }
        return false;
    }

    public Object remove(int index) {
        rangeCheck(index);
        Object elementOld = elements[index];
        resizeAndRemove(index);
        return elementOld;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public Object get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    public int indexOf(Object value) {
        if (value == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == value) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (value.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object value) {
        if (value == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (value.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(Object value) {

        return indexOf(value) >= 0;
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private void increase() {

        this.capacity *= INCREASING_COEFFICIENT;
        Object[] newElements = new Object[this.capacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private void resizeAndRemove(int index) {

        Object[] newElements = new Object[size - 1];
        for (int i = 0; i < index; i++) {
            newElements[i] = elements[i];
        }
        for (int i = index; i < size - 1; i++) {
            newElements[i] = elements[i + 1];
        }
        size--;
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

}
