package org.example.innotech.trueview.rpkib;

import lombok.SneakyThrows;

import java.util.Collection;
import java.util.Iterator;

public class ThrowEcxeption {
    public static void main(String[] args) {
        foo();

    }

    @SneakyThrows
    static void foo() {
        try {
            throw new Exception("1");
        } finally {
            throw new Exception("2");
        }
    }

}

/*
что произойдет при следующем случае? - void foo() {synchronized(obj) { doSmth();}} void bar(){ obj.add();}
ChatGPT


В вашем примере есть два метода: foo() и bar(), и foo() использует блок synchronized с объектом obj. Метод bar() вызывает метод add() на том же объекте obj. Если метод bar() вызывается параллельно с методом foo(), то вам следует учесть следующие моменты:

Метод foo() захватывает монитор объекта obj с помощью блока synchronized. Это означает, что только один поток может выполнить код внутри foo() в данный момент времени, и другие потоки будут ожидать освобождения монитора.

Если метод bar() вызывается параллельно с методом foo(), и объект obj используется в обоих методах, то метод bar() будет ожидать, пока монитор объекта obj не освободится. Это происходит потому, что метод bar() не сможет выполнить obj.add() до тех пор, пока монитор не будет освобожден методом foo().

После того как метод foo() завершит выполнение и освободит монитор объекта obj, метод bar() сможет выполнить obj.add().

Важно учесть, что если есть другие методы, использующие тот же объект obj и блок synchronized, они также будут ждать освобождения монитора, прежде чем выполниться.

В итоге, метод bar() будет ждать, пока метод foo() не освободит монитор объекта obj, и только после этого выполнит obj.add(). Это обеспечивает синхронизацию доступа к объекту obj между методами foo() и bar().
 */