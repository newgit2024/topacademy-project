package org.example.sberplatezhiiperevody.one;



import lombok.Getter;

/*
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
class RefactorAspect {

    @Pointcut("execution(* any_classes.RefactorTest.someMethod())")
    public void someMethodExecution() {
    }

    @Pointcut("execution(* any_classes.RefactorTest.someElseMethod())")
    public void someElseMethodExecution() {
    }

    @After("someMethodExecution || someElseMethodExecution")
    public void executeAfterMethod() {
        System.out.println("After method execution");
    }

    @Before("someMethodExecution || someElseMethodExecution")
    public void executeRefPrintAction() {
        RefactorTest.RefPrintAction action = RefactorTest.RefPrintActionHolder.getAction();
        action.printRef();
    }
}

 */

public class RefactorTest {

    @FunctionalInterface
    interface RefPrintAction {
        void printRef();
    }

    static class RefPrintActionHolder {
        @Getter
        private static RefPrintAction action;

        public static void setAction(RefPrintAction refPrintAction) {
            action = refPrintAction;
        }
    }

    public void someMethod() {
        System.out.println("do Some usual");
        System.out.println("do Some usual1");
        RefPrintActionHolder.setAction(RefCreator::printOperativeRef);
        System.out.println("do Some usual2");
        System.out.println("do Some usual3");
    }

    public void someElseMethod() {
        System.out.println("do Some usual");
        System.out.println("do Some usual1");
        RefPrintActionHolder.setAction(RefCreator::printhistoricalRef);
        System.out.println("do Some usual2");
        System.out.println("do Some usual3");
    }

    static class RefCreator {
        static void printOperativeRef() {
            System.out.println("operative ref");
        }

        static void printhistoricalRef() {
            System.out.println("historical ref");
        }
    }

    public static void main(String[] args) {
        RefactorTest refactorTest = new RefactorTest();
        refactorTest.someMethod();
        refactorTest.someElseMethod();
    }
}

