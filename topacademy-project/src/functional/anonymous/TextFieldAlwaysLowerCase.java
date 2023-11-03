package functional.anonymous;

public class TextFieldAlwaysLowerCase extends TextField{
    @Override
    public void onAfterInput() {
        this.text = this.text.toLowerCase();
    }

    @Override
    public void onBeforeClear() {
        System.out.println("before clear");
    }
}
