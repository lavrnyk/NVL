package ua.batimyk.io.message;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by N on 02/04/16.
 * NVL
 */
public class CustomMessageStoreTest {
    private final String TEST_PATH = "test";


    @Test
    public void testPersist() throws Exception {
        CustomMessageStore cms = new CustomMessageStore();
        ArrayList<Message> messagesList = new ArrayList<>();
        ArrayList<String> msgFromStream = new ArrayList<>();

        messagesList.add(new Message(1000, new Date(), "This message 1000"));
        cms.setFileName(TEST_PATH + "/msg.dat");

        cms.persist(messagesList.get(0));

        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(cms.getFileName())))) {
            msgFromStream.add(in.readUTF());
        }
        assertTrue(messagesList.get(0).toString().equals(msgFromStream.get(0)));

        messagesList.add(new Message(1001, null, null));

        cms.setFileName(TEST_PATH + "/msg2.dat");

        cms.persist(messagesList.get(1));
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(cms.getFileName())))) {
            msgFromStream.add(in.readUTF());
        }
        assertTrue(messagesList.get(1).toString().equals(msgFromStream.get(1)));
        assertFalse(msgFromStream.get(0).equals(msgFromStream.get(1)));


    }

    @Test
    public void testBulkPersist() throws Exception {
        Collection<Message> cmsList = new ArrayList<>();
        CustomMessageStore cms = new CustomMessageStore();

        for (int i = 0; i < 1000; i++) {
            cmsList.add(new Message(i, new Date(), "This is message " + i));
        }
        cms.setFileName(TEST_PATH + "/messages.dat");
        cms.persist(cmsList);
        Iterator<Message> iterator = cmsList.iterator();
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(cms.getFileName())))) {
            while (in.available() != 0) {
                assertTrue(iterator.next().toString().equals(in.readUTF()));
            }
        }
        assertFalse(iterator.hasNext());

    }
}