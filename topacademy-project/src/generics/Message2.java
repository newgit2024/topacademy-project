package generics;

public class Message2{
    private Object value;

    public Message2() {
    }

    public Message2( Object value) {
        this.value = value;
    }

    public  Object getValue() {
        return value;
    }

    public void setValue( Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "value=" + value +
                '}';
    }
}
