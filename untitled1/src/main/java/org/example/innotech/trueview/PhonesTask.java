package org.example.innotech.trueview;


import java.util.stream.Stream;

public class PhonesTask {

    public static void main ( String [] args) {

        Stream.of ( new Phone ( 1,"1"), new Phone ( 2,"2"))
                .map ( Object:: toString)
                .peek ( System.out:: println) //1
                .peek ( System.out:: println) //1
               // .filter ( s -> s.startsWith ("2"))// 1 1 2 2 - 2
                .sorted() // 1 1 2 2 - 1 2
                .forEach ( System.out:: println) ;
    }
    static class Phone {
        private int code ; private String number ;

        public Phone ( int code, String number) {

            this.code = code;
            this.number = number;
        }

        @Override
    public String toString () { return number ;}}}