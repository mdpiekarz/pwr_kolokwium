package zad2b;

import java.util.concurrent.locks.*;

class Bufor {
    private int[] buf;
    private int size;
    private int count;
    private int in;
    private int out;
    private Lock lock;
    private Condition notFull;
    private Condition notEmpty;

    public Bufor(int size) {
        this.size = size;
        buf = new int[size];
        count = 0;
        in = 0;
        out = 0;
        lock = new ReentrantLock();
        notFull = lock.newCondition();
        notEmpty = lock.newCondition();
    }

    public void put(int data) throws InterruptedException {
        lock.lock();
        try {
            while (count == size) {
                notFull.await();
            }
            buf[in] = data;
            in = (in + 1) % size;
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public int get() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            int data = buf[out];
            out = (out + 1) % size;
            count--;
            notFull.signal();
            return data;
        } finally {
            lock.unlock();
        }
    }
}