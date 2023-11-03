package functional.lambda.two;

public class App {
    public static void main(String[] args) {
        StringUtil stringUtil = new StringUtil();
        System.out.println(stringUtil.fromTwoString("Hello",
                "World",
                (x, y) -> x.toUpperCase() + " : " + y.toUpperCase()));
    }
}
