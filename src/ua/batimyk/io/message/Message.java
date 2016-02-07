package ua.batimyk.io.message;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by N on 02/01/16.
 * NVL
 */
public class Message implements Serializable {

    public static final long serialVersionUID = 1L;

    private int id;
    private Date date;
    private String content;

    public Message(int id, Date date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }

    public String toString() {
        return "[" + id + " , " + date + " , " + content + "]";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;


        return id == message.id && (date != null ? date.equals(message.date) : message.date == null && (content != null ? content.equals(message.content) : message.content == null));


    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
