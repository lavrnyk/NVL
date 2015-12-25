package ua.batimyk.generics;

import java.util.List;

/**
 * Created by mbatitskiy on 23-Dec-15.
 */
public class Test {
    public static void main(String[] args) {
        Container<String> container = new Container<>();
        List<Integer> src = null;
        List<String> dest = null;
        // Util.copy(src, dest);

        AL<String> list = new AL<>();
        list.add("hello");
        System.out.println(list.get(0));
    }
}

class AL<E> {
    private E[] array;

    @SuppressWarnings("unchecked")
    public AL() {
        array = (E[]) new Object[10];
    }

    void add(E value) {
        array[0] = value;
    }

    E get(int index) {
        return array[index];
    }
}

class Util {
    static <V> void copy(List<V> source, List<V> dest) {

    }
}

class Pair<A, B> {
    A first;
    B second;
}

class Container<V> {
    V element;

    public V getElement() {
        return element;
    }

    public void setElement(V element) {
        this.element = element;
    }
}
