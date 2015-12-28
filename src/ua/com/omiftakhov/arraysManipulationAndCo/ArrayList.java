package ua.com.omiftakhov.arraysManipulationAndCo;

/**
 * Created by omiftakhov on 28.12.2015.
 */
public class ArrayList implements List {
    private Object[] array = new Object[2];
    private int size;

    @Override
    public void add(Object value) {
        add(size, value);
    }

    @Override
    public void add(int index, Object value) {
        if (index != size) {
            validateIndex(index);
        }
        if (array.length == size) {
            Object[] arrayTemp = new Object[size * 2];
            System.arraycopy(array, 0, arrayTemp, 0, size);
            array = arrayTemp;
        }
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public Object set(int index, Object value) {
        validateIndex(index);
        array[index] = value;
        return value;
    }

    @Override
    public Object remove(int index) {
        validateIndex(index);
        Object resutl = get(index);
        if (index != size - 1) {
            System.arraycopy(array, index + 1, array, index, size - index);
        }
        size--;
        return resutl;
    }

    @Override
    public void clear() {
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
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(value)) {
                return i;
            }
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
}