package org.example.streams;

public class ClassA {
    //StackOverFlow
    private ClassA classA = new ClassA () ;
    private Integer number ;
    public Integer getNumber () { return number ;}}
class ClassB {
    public static void main(String[] args) {
        ClassA a = new ClassA();
        //NullPointerException
        int number = a.getNumber();
        System.out.println(number);
    }
}
