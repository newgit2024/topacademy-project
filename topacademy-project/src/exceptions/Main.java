package exceptions;

public class Main {
    static Object object;
    public static void foo() throws NullPointerException, ArithmeticException {
        try {
            //System.out.println(object.toString());
            System.out.println(1 / 0);
        } finally {
            System.out.println("end of foo method!!!");
        }
    }
    public static void main(String[] args) {
        foo();
    }
}