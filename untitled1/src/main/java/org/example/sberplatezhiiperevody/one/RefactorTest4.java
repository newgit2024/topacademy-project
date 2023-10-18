package org.example.sberplatezhiiperevody.one;

import org.aspectj.lang.annotation.*;
public class RefactorTest4 {
    private Runnable refStrategy;

    public RefactorTest4(Runnable refStrategy) {
        this.refStrategy = refStrategy;
    }

    public void someMethod() {
        doCommon();
    }

    public void someElseMethod() {
        doCommon();
    }

    private void doCommon() {
        //System.out.println("do Some usual");
        //System.out.println("do Some usual1");
        refStrategy.run();
        //System.out.println("do Some usual2");
        //System.out.println("do Some usual3");
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
        RefactorTest4 operativeRefTest = new RefactorTest4(operativeRefStrategy);
        operativeRefTest.someMethod();

        Runnable historicalRefStrategy = RefCreator::printHistoricalRef;
        RefactorTest4 historicalRefTest = new RefactorTest4(historicalRefStrategy);
        historicalRefTest.someElseMethod();
    }


}




@Aspect
class BeforeRefStrategyAspect {
    @Before("execution(void org.example.sberplatezhiiperevody.one.RefCreator.*(..))")
    public void beforeRefStrategy() {
        System.out.println("do Some usual");
        System.out.println("do Some usual1");
    }
}

@Aspect
class AfterRefStrategyAspect {
    @After("execution(void org.example.sberplatezhiiperevody.one.RefCreator.*(..))")
    public void afterRefStrategy() {
        System.out.println("do Some usual2");
        System.out.println("do Some usual3");
    }
}