package functional.lambda;

public class TextField {
    protected String text;

    private TextFieldEvent onBeforeClear;
    private TextFieldInputEvent onAfterInput;

    public void input(String text){
        this.text = onAfterInput.handle(text);
    }
    public void clear(){
        onBeforeClear.handle();
        this.text = null;
    }

    public void onAfterInput(TextFieldInputEvent onAfterInput){
        this.onAfterInput = onAfterInput;
    }

    public void  onBeforeClear (TextFieldEvent onBeforeClear){
        this.onBeforeClear = onBeforeClear;
    }

    public String getText() {
        return text;
    }
}
