package org.example;

public class LiveCoding3 {
    public static void main(String[] args) {
        System.out.println(bigNumber("555123", 2));
    }

    //0...9
    //O(n2)
    //O(n)
    //Stream API, SQL
    public static String bigNumber(String s, // big num < Long "75574875457 8"
                                   int num // string * num
    ) {
        char[] numArray = s.toCharArray();
        int buf = 0;
        StringBuilder result = new StringBuilder();
        for (int j = s.length() - 1; j >= 0; j--) {
            int numArrayVal = Character.getNumericValue(numArray[j]);
            int res = numArrayVal * num + buf;
            if (res >= 10) {
                buf = res / 10;
                result.append(res % 10);
            } else {
                result = result.append(numArrayVal * num);
            }
        }
        if (buf != 0) {
            result.append(buf);
        }
        return result.reverse().toString();
    }
}
