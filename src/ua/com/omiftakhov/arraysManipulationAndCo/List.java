package ua.com.omiftakhov.arraysManipulationAndCo;

/**
 * Created by omiftakhov on 28.12.2015.
 */
public interface List {

    void add(Object value);

    void add(int index, Object value);

    Object set(int index, Object value);

    Object remove(int index);

    int size();

    boolean isEmpty();

    void clear();

    Object get(int index);

    int indexOf(Object value);

    int lastIndexOf(Object value);

    boolean contains(Object value);
}
