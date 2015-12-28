package ua.batimyk.list;

import org.junit.Assert;
import org.junit.Test;


/**
 * Created by mbatitskiy on 25-Dec-15.
 */
public class ArrayListTest {

    @Test
    public void testAdd() throws Exception {
        ArrayList list = new ArrayList();
        list.add("a0");
        list.add("a1");
        list.add(null);
        Assert.assertEquals("a0", list.get(0));
        Assert.assertEquals("a1", list.get(1));
        Assert.assertEquals(null, list.get(2));
        Assert.assertNotEquals("a2", list.get(0));
        Assert.assertNotEquals(null, list.get(1));
        Assert.assertEquals(3, list.size());
        ArrayList listLong = new ArrayList();
        listLong.add(12345L);
        listLong.add(1234567890L);
        Assert.assertEquals(12345L, listLong.get(0));
        Assert.assertEquals(1234567890L, listLong.get(1));
        Assert.assertNotEquals(1, listLong.get(0));
    }

    @Test
    public void testAddByIndex() throws Exception {
        ArrayList list = new ArrayList();
        list.add(0, "a0");
        list.add(0, "a1");
        list.add(0, "a2");
        list.add(3, 12345L);
        Assert.assertEquals("a0", list.get(2));
        Assert.assertEquals("a1", list.get(1));
        Assert.assertEquals("a2", list.get(0));
        Assert.assertEquals(12345L, list.get(3));
    }

    @Test
    public void testSet() throws Exception {
        ArrayList list = new ArrayList();
        list.add("a0");
        list.add("a1");
        list.add("a2");
        list.add(12345L);
        list.set(0, "b0");
        list.set(1, 12345L);
        list.set(2, "b1");
        Assert.assertEquals("b1", list.get(2));
        Assert.assertEquals(12345L, list.get(1));
        Assert.assertEquals("b0", list.get(0));
    }

    @Test
    public void testRemove() throws Exception {
        ArrayList list = new ArrayList();
        int tempSize = 1000;
        for (int i = 0; i < tempSize; i++) {
            list.add("a" + i);
        }
        for (int i = 0; i < tempSize / 2; i++) {
            Assert.assertTrue(list.remove("a" + i));
        }
        Assert.assertEquals(tempSize / 2, list.size());
    }

    @Test
    public void testRemoveByIndex() throws Exception {
        ArrayList list = new ArrayList();
        int tempSize = 1000;
        for (int i = 0; i < tempSize; i++) {
            list.add("a" + i);
        }
        for (int i = 0; i < tempSize / 2; i++) {
            list.remove(0);
        }
        Assert.assertEquals("a" + tempSize / 2, list.get(0));
        Assert.assertEquals("a" + (tempSize - 1), list.get(Math.round((tempSize - 1) / 2)));
    }

    @Test
    public void testSize() throws Exception {
        ArrayList list = new ArrayList();
        int tempSize = 1000;
        for (int i = 0; i < tempSize; i++) {
            list.add(null);
        }
        Assert.assertEquals(tempSize,list.size());
        ArrayList listLong = new ArrayList();
        for (int i = 0; i < tempSize; i++) {
            listLong.add((long)i);
        }
        Assert.assertEquals(tempSize,listLong.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        ArrayList list = new ArrayList();
        Assert.assertTrue(list.isEmpty());


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

}