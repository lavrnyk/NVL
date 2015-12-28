package ua.com.omiftakhov.arraysManipulationAndCo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
/**
 * Created by omiftakhov on 28.12.2015.
 */
public class ListTest {
    List list;

    @Before
    public void setUp() throws Exception {
        //example
        //list= new ArrayList();

    }

    @Test
    public final void testAdd() throws Exception {
        list.add("one");
        assertEquals("one",list.get(0));

    }

    @Test
    public final void testAddindex() throws Exception {
        list.add("one");
        list.add("three");
        list.add(1,"two");
        assertEquals("two",list.get(1));
    }

    @Test
    public final void testGet() throws Exception {
        list.add("one");
        list.add("two");
        list.add("three");
        assertEquals("two",list.get(1));
    }

    @Test
    public final void testSet() throws Exception {
        list.add("one");
        list.add("two");
        list.add("three");
        list.set(1,"set=two");
        assertEquals("set=two",list.get(1));

    }

    @Test
    public final void testRemove() throws Exception {
        list.add("one");
        list.add("two");
        list.add("three");
        list.remove(1);
        assertEquals("three",list.get(1));
        assertEquals("one",list.get(0));
        assertEquals(2,list.size());
    }

    @Test
    public final void testClear() throws Exception {
        list.add("one");
        list.add("two");
        list.add("three");
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public final void testSize() throws Exception {
        list.add("one");
        list.add("two");
        list.add("three");
        assertEquals(3,list.size());
    }

    @Test
    public final void testIsEmpty() throws Exception {
        assertEquals(true,list.isEmpty());
        list.add("one");
        assertEquals(false,list.isEmpty());
    }

    @Test
    public final void testIndexOf() throws Exception {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("two");
        list.add("four");
        assertEquals(1,list.indexOf("two"));
        assertEquals(4,list.lastIndexOf("four"));
        assertEquals(0,list.lastIndexOf("one"));
        assertEquals(-1,list.indexOf("zzzz"));
    }

    @Test
    public final void testLastIndexOf() throws Exception {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("two");
        list.add("four");
        assertEquals(3,list.lastIndexOf("two"));
        assertEquals(4,list.lastIndexOf("four"));
        assertEquals(0,list.lastIndexOf("one"));
        assertEquals(-1,list.lastIndexOf("zzzz"));
    }

    @Test
    public final void testContains() throws Exception {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("two");
        list.add("one");
        assertEquals(true,list.contains("three"));
        assertEquals(false,list.contains("zzz"));

    }
}
