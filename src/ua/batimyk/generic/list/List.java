package ua.batimyk.generic.list;

/**
 * Created by ${USER} on ${DATE}.
 * NVL
 */
public interface List<E> {

    void add(E element);

    void add(int index, E element);

    E set(int index, E element);

    E remove(int index);

    boolean remove(E element);

    int size();

    boolean isEmpty();

    void clear();

    E get(int index);

    int indexOf(E element);

    int lastIndexOf(E element);

    boolean contains(E element);

}
