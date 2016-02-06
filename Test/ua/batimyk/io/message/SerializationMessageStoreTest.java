package ua.batimyk.io.message;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by N on 02/04/16.
 * NVL
 */
public class SerializationMessageStoreTest {
    private final String TEST_PATH = "test";

    @Test
    public void testPersist() throws Exception {
        SerializationMessageStore sms = new SerializationMessageStore();

        ArrayList<Message> messagesList = new ArrayList<>();
        ArrayList<Message> msgFromStream = new ArrayList<>();

        messagesList.add(new Message(1000, new Date(), "This message 1000"));
        sms.setFileName(TEST_PATH + "/msg.dat");

        sms.persist(messagesList.get(0));

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(sms.getFileName()))) {
            msgFromStream.add((Message) in.readObject());
        }
        assertTrue(messagesList.get(0).equals(msgFromStream.get(0)));

        messagesList.add(new Message(1001, null, null));

        sms.setFileName(TEST_PATH + "/msg2.dat");

        sms.persist(messagesList.get(1));
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(sms.getFileName()))) {
            msgFromStream.add((Message) in.readObject());
        }
        assertTrue(messagesList.get(1).equals(msgFromStream.get(1)));
        assertFalse(msgFromStream.get(0).equals(msgFromStream.get(1)));
    }

    @Test
    public void testBulkPersist() throws Exception {
        Collection<Message> smsList = new ArrayList<>();
        SerializationMessageStore sms = new SerializationMessageStore();

        for (int i = 0; i < 1000; i++) {
            smsList.add(new Message(i, new Date(), "This is message " + i));
        }
        sms.setFileName(TEST_PATH + "/messages.dat");
        sms.persist(smsList);
        Iterator<Message> iterator = smsList.iterator();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(sms.getFileName()))) {
            @SuppressWarnings("unchecked")
            Collection<Message> msg = new LinkedList<>((Collection<Message>) in.readObject());
           for(Message m : msg) {
               assertTrue(m.equals(iterator.next()));
           }
        }
        assertFalse(iterator.hasNext());
    }
}