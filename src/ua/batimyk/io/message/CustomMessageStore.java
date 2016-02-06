package ua.batimyk.io.message;


import java.io.*;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by N on 02/01/16.
 * NVL
 */
public class CustomMessageStore implements MessageStore {

    private String fileName = "messagesUTF.dat";

    public void setFileName(String path){
        this.fileName = path;
    }

    public void persist(Message message) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            out.writeUTF(message.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void persist(Collection<Message> list) {
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            for (Message m : list) {
                out.writeUTF(m.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileName() {
        return fileName;
    }

    public static void main(String[] args) throws IOException {

        Collection<Message> cmsList = new LinkedList<>();

        CustomMessageStore cms = new CustomMessageStore();

        for (int i = 0; i < 1000; i++) {
            cmsList.add(new Message(i, new Date(), "This is message " + i));
        }
        cms.persist(cmsList);

        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(cms.getFileName())))) {
            while (in.available() != 0) {
                System.out.println(in.readUTF());
            }

        }

    }
}
