package functional.methodreference;

import functional.lambda.TextFieldEvent;
import functional.lambda.TextFieldInputEvent;

public class TextField {
    protected String text;
    public void input(String text, StringProcess stringProcess){
        this.text = stringProcess.process(text);
    }
    public String getText() {
        return text;
    }
}
