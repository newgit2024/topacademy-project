package inheritance;

public class Square extends Rectangle{
    public Square(int x, int y, int a) {
        super(x, y, a, a);
    }

    @Override
    public void print() {
        System.out.println("Square{" +
                "b=" + b +
                '}');
    }

}
