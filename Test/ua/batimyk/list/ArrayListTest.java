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
    public void testAddByIndex() throws Exception {

    }

    @Test
    public void testSet() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }

    @Test
    public void testRemoveByIndex() throws Exception {

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
        ua.batimyk.list.ArrayList list = new ua.batimyk.list.ArrayList();

        for(int i= 0; i < 20; i++) {
            list.add("a"+i);
        }
        list.remove();
        for(int i= 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.get(19));
    }
}