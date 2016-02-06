package ua.batimyk.io.message;


import java.io.*;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by N on 02/01/16.
 * NVL
 */
public class SerializationMessageStore implements MessageStore {

    private String fileName = "messages.dat";

    public void setFileName (String path) {
       this.fileName = path;
    }

    public void persist(Message message) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void persist(Collection<Message> list) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Collection<Message> smsList = new LinkedList<>();

        SerializationMessageStore sms = new SerializationMessageStore();

        for (int i = 0; i < 100; i++) {
            smsList.add(new Message(i, new Date(), "This is message " + i));
        }
        sms.persist(smsList);

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(sms.getFileName()))) {
            @SuppressWarnings("unchecked")
            Collection<Message> msg = new LinkedList<>((Collection<Message>) in.readObject());
            for(Object m : msg)  {
                System.out.println(m);
            }
        }
    }
}
