package functional.lambda.two;

public class StringUtil {
    private int minLength;
    private TwoStringOperation defaultOperation = (a, b) -> {
        if (a.length() > this.minLength && b.length() > this.minLength){
            return a + " " + b;
        } else return a + b;
    };

    public String fromTwoString (String a, String b, TwoStringOperation operation){
        if (operation == null){
            operation = defaultOperation;
        }
        return operation.process(a, b);
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }
}
