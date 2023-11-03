package generics;

public class Post <K extends Number, V>{
    private K id;
    private V message;

    public K getId() {
        return id;
    }

    public void setId(K id) {
        this.id = id;
    }

    public V getMessage() {
        return message;
    }

    public void setMessage(V message) {
        this.message = message;
    }
}
