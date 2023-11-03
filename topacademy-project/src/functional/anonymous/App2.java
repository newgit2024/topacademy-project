package functional.anonymous;

import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
        List<Integer> sizes = new ArrayList<>();
        TextField textField = new TextField() {
            private List<String> history = new ArrayList<>();
            @Override
            public void onAfterInput() {
                this.text = this.text.toUpperCase();
                sizes.add(text.length());
            }

            @Override
            public void onBeforeClear() {
                this.history.add(this.text);
                System.out.println("History" + history);
            }

            @Override
            public String getText() {
                return "<" + this.text + ">";
            }
        };

        textField.input("hello");
        textField.clear();
        textField.input("how are you?");
        textField.clear();
        textField.input("bye");
        System.out.println(textField.getText());
        textField.clear();
        System.out.println(sizes);
    }
}
