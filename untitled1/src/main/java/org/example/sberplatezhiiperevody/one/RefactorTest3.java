package org.example.sberplatezhiiperevody.one;

public class RefactorTest3 {
    private Runnable refStrategy;

    public RefactorTest3(Runnable refStrategy) {
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
        refStrategy.run();
        System.out.println("do Some usual2");
        System.out.println("do Some usual3");
    }

    static class RefCreator {
        static void printOperativeRef() {
            System.out.println("operative ref");
        }

        static void printHistoricalRef() {
            System.out.println("historical ref");
        }
    }

    public static void main(String[] args) {
        Runnable operativeRefStrategy = RefCreator::printOperativeRef;
        RefactorTest3 operativeRefTest = new RefactorTest3(operativeRefStrategy);
        operativeRefTest.someMethod();

        Runnable historicalRefStrategy = RefCreator::printHistoricalRef;
        RefactorTest3 historicalRefTest = new RefactorTest3(historicalRefStrategy);
        historicalRefTest.someElseMethod();
    }


}
