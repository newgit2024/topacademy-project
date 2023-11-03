package functional.methodreference;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        TextField textField = new TextField();
        TextProcessor textProcessor = new TextProcessor(LocalDate.now().toString(), ".txt");
        StringProcess textWithAddition = textProcessor::processWithAddition;
        textField.input("Hello", TextProcessor::process);
        textField.input("How R U?", textWithAddition);
        System.out.println(textField.getText());

        var list = List.of("a", " b", "c")
                .stream()
                .map(StringBuilder::new)
                .filter(s -> s.length() > 10)
                .collect(Collectors.toList());


    }
}
