package org.example.inters.sergeimarchenko;
//deadlock?
// without sync - race condition
// with sync - deadlock
// need change
public class ThreadDemo {

    public static void main(String[] args) {
        Account a1 = new Account();
        Account a2 = new Account();
        new Thread(()->{
            thread1(a1, a2);//order of args
        }).start();

        new Thread(()->{
            thread2(a2, a1);
        }).start();
    }

     static void thread1(Account a1, Account a2){
        swap(a1, a2);

    }

    static void thread2(Account a1, Account a2){
        swap(a1, a2);

    }

    static void swap(Account a1, Account a2){
        synchronized (a1){
            synchronized (a2){

            }
        }
    }
}
