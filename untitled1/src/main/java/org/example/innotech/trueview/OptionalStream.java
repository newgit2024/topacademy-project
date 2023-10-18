package org.example.innotech.trueview;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class OptionalStream {

    public static void main(String[] args) {
        var val = Stream.of(null)
                //.findAny()
                //.max(Comparator.naturalOrder());
                //.reduce(Integer::sum);
                //.min(Comparator.comparing(String::length));
                .findFirst() //NPE
                .orElse("hello");
        System.out.println(val);
    }
}



