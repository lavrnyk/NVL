package ua.batimyk.list;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by mbatitskiy on 25-Dec-15.
 */
public class ArrayListTest {

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testAdd1() throws Exception {

    }

    @Test
    public void testSet() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }

    @Test
    public void testIsEmpty() throws Exception {

    }

    @Test
    public void testClear() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testIndexOf() throws Exception {

    }

    @Test
    public void testLastIndexOf() throws Exception {

    }

    @Test
    public void testContains() throws Exception {

    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add('a');
        list.add('b');
        list.add('c');

        System.out.println(list.size());
        list.set(-1, 'd');
        System.out.println(list.size());

        System.out.println(100>>2);

    }
}