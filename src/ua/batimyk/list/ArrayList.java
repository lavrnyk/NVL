package ua.batimyk.list;

/**
 * Created by mbatitskiy on 24-Dec-15.
 */
public class ArrayList implements List {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private static final float INCRFEASING_COEFFICIENT = 1.5f;

    protected int capacity = 0;

    Object[] elements;

    public void add(Object value) {
        elements[size++] = value;
    }

    public void add(int index, Object value){
        rangeCheckAdd(index);
    }

    public Object set(int index, Object value){
        rangeCheck(index);
        Object elementOld = elements[index];
        elements[index] = value;
        return elementOld;
    }

    public Object remove(int index){
        rangeCheck(index);
        Object elementOld = elements[index];
        return elementOld;
    }

    public int size(){
       return size;
    }

    public boolean isEmpty(){
       return size == 0;
    }

    public void clear(){

    }

    public Object get(int index){
        rangeCheck(index);
        return elements[index];
    }

    public int indexOf(Object value){
        return -1;
    }

    public int lastIndexOf(Object value){
        return -1;
    }

    public boolean contains(Object value){
        return false;
    }

    private void rangeCheck(int index){
        if(index > size ) {
            throw new IndexOutOfBoundsException("Index: "+ index +", Size: "+ size);
        }
    }

    private void rangeCheckAdd(int index){
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: "+ index +", Size: "+ size);
        }
    }

    private void increase(int capacity) {
        if(capacity > this.capacity)
        {
            this.capacity *= INCRFEASING_COEFFICIENT;
        }
    }

    private void checkCapacity(int capacity) {

    }
}
