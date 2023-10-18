package org.example.sberplatezhiiperevody.four;

public class Test {
    static String join(String[] args) {
        if (args == null || args.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder(args[0]);

        for (int i = 1; i < args.length; i++) {
            result.append(", ").append(args[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        args = new String[]{"a", "b", "c"};

        System.out.println(join(args));
    }
}
