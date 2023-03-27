package javacore.counter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private volatile int count = 0;
    private final Lock lock;
    public Counter() {
        lock = new ReentrantLock();
    }
    public void inc() {
        lock.lock();
        try {
            count++;
        } finally {
            System.out.println("Thread " + Thread.currentThread().getName() + " incrementing count to " + getCount());
            lock.unlock();
        }
    }
    public void dec() {
        lock.lock();
        try {
            count--;
        } finally {
            System.out.println("Thread " + Thread.currentThread().getName() + " derementing count to " + getCount());
            lock.unlock();
        }
    }
    public int getCount() {
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
}