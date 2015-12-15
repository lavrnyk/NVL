package ua.lavrenov;

import java.util.ArrayList;

public class HashMap {

    ArrayList<Entry[]> array = new ArrayList(15);

    public static void main(String[] args) {

    }

/*    public void put(Object key, Object value) {
        Entry entry = new Entry(key, value);
        int bucket = key.hashCode() % array.length;
        ArrayList arr = new ArrayList<Entry>();
        arr.add(entry);
        array[bucket].addAll(arr);
    }*/
}

