package org.example.sberplatezhiiperevody;

public class Test3 {
    public static String join(String [] args) {
        String result = "";
        for (String arg : args) {
            result += arg;
            result += " .";
        }

        return result;
    }

    public static void main(String[] args) {
        /*
        List<String> args2 = IntStream.range(0, 100)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.toList());

         */

        args = new String[]{"1", "2", "3"};

        System.out.println(join(args));
    }
}

