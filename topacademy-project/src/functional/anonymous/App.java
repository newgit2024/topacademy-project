package functional.anonymous;

public class App {
    public static void main(String[] args) {
        TextField alwaysLowerCase = new TextFieldAlwaysLowerCase();
        alwaysLowerCase.input("PV123");
        System.out.println(alwaysLowerCase.getText());
    }
}
