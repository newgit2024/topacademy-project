package inheritance;

public class Rectangle extends Figure{
    private int a;
    protected int b;

    public Rectangle(int x, int y, int a, int b) {
        super(x, y);
        this.a = a;
        this.b = b;
    }
    public void scale(int value){
        this.a *= value;
        this.b *= value;
    }
    public int getPerimeter(){
        return this.a *2 + this.b * 2;
    }
    public int getArea(){
        return this.a * this.b;
    }

    @Override
    public void print() {
        System.out.println("Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}');
    }
}
