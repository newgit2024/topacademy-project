package inheritance;

public abstract class Figure {
    private int x;
    private int y;

    public Figure(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }
    public abstract void print();
}
