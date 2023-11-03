package gc;

public class Demo {
    public static void main(String[] args) {
        Student student = new Student();
        student = null;

        Student s1 = new Student();//s1 - s2
        Student s2 = new Student();
        s1 = s2;


        /*
        try {
            s1.finalize();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

         */

        // System.gc();
        // Runtime.gc();

        System.out.println(new Student());

        //...
    }
}

class Student {
    /*
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

     */
}
