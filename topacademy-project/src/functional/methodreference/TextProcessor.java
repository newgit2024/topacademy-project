package functional.methodreference;

public class TextProcessor {
    private String prefix;
    private String postfix;


    public TextProcessor(String prefix, String postfix) {
        this.prefix = prefix;
        this.postfix = postfix;
    }
    public String processWithAddition(String text){
        return this.prefix + " " + text + " " + this.postfix;
    }
    public static String process(String text){
        if (text.contains(" ")){
            return text.replace(" ", "_");
        } else {
            return text;
        }
    }
}
