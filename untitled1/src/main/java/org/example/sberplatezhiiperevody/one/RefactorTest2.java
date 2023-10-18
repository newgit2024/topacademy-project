package org.example.sberplatezhiiperevody.one;

public class RefactorTest2 {
    private RefStrategy refStrategy;

    public RefactorTest2(RefStrategy refStrategy) {
        this.refStrategy = refStrategy;
    }

    public void someMethod() {
        doCommon();
    }

    public void someElseMethod() {
        doCommon();
    }

    private void doCommon() {
        System.out.println("do Some usual");
        System.out.println("do Some usual1");
        refStrategy.printRef();
        System.out.println("do Some usual2");
        System.out.println("do Some usual3");
    }

    public static void main(String[] args) {
        RefactorTest2 operativeRefTest = new RefactorTest2(RefCreator2::printOperativeRef);
        operativeRefTest.someMethod();

        RefactorTest2 historicalRefTest = new RefactorTest2(RefCreator2::printHistoricalRef);
        historicalRefTest.someElseMethod();
    }

    @FunctionalInterface
    interface RefStrategy {
        void printRef();
    }

    static class RefCreator2 {
        static void printOperativeRef() {
            System.out.println("operative ref");
        }

        static void printHistoricalRef() {
            System.out.println("historical ref");
        }
    }
}
