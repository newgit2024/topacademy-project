package collections;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, Integer> hm = new HashMap<>();
        hm.put("Argentina", 1);
        hm.put("Norway", 12);
        hm.put("Canada", 10);
        hm.put("USA", 5);
        for (Map.Entry m : hm.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }


        Map<Fish, Double> wtm = new WeakHashMap<>();
        Fish f1 = new Fish("eel", 1.5, 120);
        Fish f2 = new Fish("salmon", 2.5, 180);
        Fish f3 = new Fish("trout", 3.2, 220);
        wtm.put(f1, 120.0);
        wtm.put(f2, 180.0);
        wtm.put(f3, 220.0);
        System.out.println("Before:");
        for (Object eo : wtm.entrySet()) {
            Map.Entry e = (Map.Entry) eo;
            System.out.println(e.getKey() + "->" + e.getValue());
        }
        f2 = null;
//do something huge to invoke garbage collector
        for (int i = 0; i < 10000; i++) {
            byte b[] = new byte[1000000];
            b = null;
        }
        System.out.println("After:");
        for (Object eo : wtm.entrySet()) {
            Map.Entry e = (Map.Entry) eo;
            System.out.println(e.getKey() + "->" + e.getValue());
        }

        Fish f = new Fish("shark", 2000, 22000);

        WeakReference<Fish> weakReference = new WeakReference<>(f);
        for (int i = 0; i < 10000; i++) {
            byte b[] = new byte[1000000];
            b = null;
        }
        System.out.println(weakReference.get());

        SoftReference<Fish> softReference = new SoftReference<>(f);
        for (int i = 0; i < 10000; i++) {
            byte b[] = new byte[1000000];
            b = null;
        }
        System.out.println(softReference.get());

        PhantomReference<Fish> phantomReference = new PhantomReference<>(f, new ReferenceQueue<>());
        System.out.println(phantomReference.get());


       // Dictionary
        //Object

    }
}
