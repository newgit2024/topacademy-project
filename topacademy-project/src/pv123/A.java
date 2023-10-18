package pv123;

class A {
    void a(){}
    void b(){}

    static void c(){}


}
class B extends A{
    void a() {
        System.out.println("b");
    }

    @Override
    void b() {
        super.b();
    }
}

