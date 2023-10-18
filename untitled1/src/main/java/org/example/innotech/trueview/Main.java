package org.example.innotech.trueview;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Map<Somekey, String> test = new HashMap<>();
        Somekey key1 = new Somekey(" firstKey");
        Somekey key2 = new Somekey(" secondKey");
        test.put(key1, " firstValue");
        test.put(key2, " secondValue");
        System.out.println(test.get(key1));//?
        Somekey key3 = new Somekey(" secondKey");
        System.out.println(test.get(key3));//?
        key2.value = ""; //если бы хэшкод реализовали норм то значение поменялось - и оно бы не нашлось
        System.out.println(test.get(key2));//

        // firstValue
        // secondValue
        // secondValue
    }
}

class Somekey {
    public String value;


    public Somekey(String value) {
        this.value = value;
    }

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Somekey) {
            return value.equals(((Somekey) obj).value);
        }
        return false;
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(value);
    }*/
    //  |
    //  V
    //firstValue
    // secondValue
    //null
}


