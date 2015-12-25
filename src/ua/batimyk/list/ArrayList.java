package ua.batimyk.list;

/**
 * Created by mbatitskiy on 24-Dec-15.
 */
public class ArrayList implements List {

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    Object[] element;

    void add(Object value) {
        element[size++] = value;
    }

    void add(int index, Object value){
        rangeCheck(index);
    }

    Object set(int index, Object value){
        rangeCheck(index);
        Object elementOld = element[index];
        element[index] = value;
        return elementOld;
    }

    Object remove(int index){
        rangeCheck(index);
        Object elementOld = element[index];
        return elementOld;
    }

    int size(){
       return size;
    }

    boolean isEmpty(){
       return size == 0;
    }

    void clear(){

    }

    Object get(int index){
        rangeCheck(index);
        return element[index];
    }

    int indexOf(Object value){
        return -1;
    }

    int lastIndexOf(Object value){
        return -1;
    }

    boolean contains(Object value){
        return false;
    }

    private void rangeCheck(int index){
        if(index >= size) {
            throw new IndexOutOfBoundsException("Index: "+ index +", Size: "+ size);
        }
    }

}
