package javacore.counter;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        CounterUse counterUse = new CounterUse(counter);
        Thread t1 = new Thread(counterUse);
        Thread t2 = new Thread(counterUse);
        Thread t3 = new Thread(counterUse);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
