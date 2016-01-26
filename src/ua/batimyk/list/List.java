package ua.batimyk.list;

/**
 * Created by mbatitskiy on 24-Dec-15.
 */
public interface List {

    void add(Object value);

    void add(int index, Object value);

    Object set(int index, Object value);

    Object remove(int index);

    boolean remove(Object value);

    int size();

    boolean isEmpty();

    void clear();

    Object get(int index);

    int indexOf(Object value);

    int lastIndexOf(Object value);

    boolean contains(Object value);

}