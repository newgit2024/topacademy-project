package functional.lambda;

public class App {
    public static void main(String[] args) {
        TextFieldInputEvent onAfterInput = s -> s.toUpperCase();

        TextFieldEvent onBeforeClear = () -> {
            System.out.println("Attention!");
            System.out.println("Something war written!!!");
        };

        TextField textField = new TextField();
        textField.onAfterInput(onAfterInput);
        textField.onBeforeClear(onBeforeClear);

        textField.input("Hi");
        textField.clear();
        textField.input("How R U?");
        textField.clear();
        textField.input("Fine");
        System.out.println(textField.getText());
        textField.clear();
    }
}
