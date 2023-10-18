package staticjava;

import java.util.Random;

public class A {
    int f;
    static int staticF;
    static {
        Random random = new Random();
        staticF = random.nextInt(100);
        methodStatic();
    }
    public void method(){
        System.out.println(f);
        System.out.println(staticF);
    }

    public static void methodStatic(){
        //System.out.println(f);
        System.out.println(staticF);
    }


}
