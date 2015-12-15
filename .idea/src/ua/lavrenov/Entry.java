package ua.lavrenov;

public class Entry {
    Object key;
    Object value;

    public static void main(String[] args) {

    }
    public Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
