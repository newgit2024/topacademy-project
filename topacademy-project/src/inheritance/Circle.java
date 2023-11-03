package inheritance;

public class Circle extends Ellipse {

    public Circle(int x, int y, int r) {
        super(x, y, r, r);
    }

    @Override
    public void print() {
        System.out.println("r = " + r1);
    }
}
