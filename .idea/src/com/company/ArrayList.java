package com.company;

public class ArrayList {
    int[] array;
    int size;

    ArrayList() {
        array = new int[5];
    }

    void add(int index, int value) {
        if (size == array.length) {
            int[] extendedArray = new int[(int)(array.length *1.5)];
            System.arraycopy(array, 0, extendedArray,0,array.length);
            array = extendedArray;
        }
        size++;
        for (int i = index; i < size-1; i++){
            set(i+1,get(i));
        }
        set(index,value);

    }


    void add(int value) {
        if (size == array.length) {
            int[] extendedArray = new int[(int)(array.length *1.5)];
            System.arraycopy(array, 0, extendedArray,0,array.length);
            array = extendedArray;
        }
        array[size] = value;
        size++;
    }


    int get(int index) {
        validateIndex(index);
        return array[index];
    }

    void set(int index, int value){
        validateIndex(index);
        array[index] = value;
    }

    int indexOf(int value) {
        for (int i = 0; i < size; i++){
            if (value == array[i]) {
                return i;
            }
        }
        return -1;
    }

    int lastIndexOf(int value) {
        for (int i = size-1; i>=0  ; i--){
            if (value == array[i]) {
                return i;
            }
        }
        return -1;
    }

    void remove (int index) {
        validateIndex(index);
        for (int i = index; i < size; i++) {
            if (i == size -1) {
                set(i,0);
            }
            else {
                set(i, get(i+1));
            }
        }
        size--;
    }

    public String toString() {
        String result = "";
        for (int value : array) {
            result = result + value + ", ";
        }
        return "[" + result + "]";
    }


    void validateIndex(int index){
        if (index < 0 || index >= size) { // size
            String message = "Index " + index + " should " +
                    "be between 0 and " + (size - 1);
            throw new IndexOutOfBoundsException(message);
        }
    }
}