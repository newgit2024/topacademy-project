package org.example.innotech.trueview.rpkib;

import java.util.Collection;
import java.util.Iterator;

public class DeleteABC {
    public static void main(String[] args) {

    }

    static void foo(Collection<String> strings) {
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if (str != null && str.startsWith("abc")) {
                iterator.remove();
            }
        }
    }

}
