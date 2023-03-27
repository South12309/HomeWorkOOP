package javacore.counter;



public class CounterUse implements Runnable{
    private final Counter counter;
    public CounterUse(Counter counter) {
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.inc();
            //    counter.dec();
        }
    }
}
