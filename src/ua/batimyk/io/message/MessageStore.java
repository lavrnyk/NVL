package ua.batimyk.io.message;

import java.util.Collection;

/**
 * Created by N on 02/01/16.
 * NVL
 */
public interface MessageStore {


    void persist(Message message);

    void persist(Collection<Message> list);
}
