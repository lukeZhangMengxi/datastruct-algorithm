package concurrency.print_in_order;

import java.util.concurrent.atomic.AtomicInteger;

interface Solution {
    void init();
    void first(Runnable printFirst) throws InterruptedException;
    void second(Runnable printSecond) throws InterruptedException;
    void third(Runnable printThird) throws InterruptedException;
}

class UsePairSynchronization implements Solution {

    private AtomicInteger firstJobDone;
    private AtomicInteger secondJobDone;

    @Override
    public void init() {
        firstJobDone = new AtomicInteger(0);
        secondJobDone = new AtomicInteger(0);
    }

    @Override
    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstJobDone.incrementAndGet();
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {
        while (firstJobDone.get() != 1) {
            // wait
        }

        printSecond.run();
        secondJobDone.incrementAndGet();
    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {
        while (secondJobDone.get() != 1) {
            // wait
        }

        printThird.run();
    }

}

class UseMonitorLock implements Solution {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Object lock = new Object();

    @Override
    public void init() {
        counter.set(0);
    }

    @Override
    public void first(Runnable printFirst) throws InterruptedException {
        synchronized(lock) {
            while (counter.get() != 0) {
                lock.wait();
            }

            printFirst.run();
            counter.incrementAndGet();
            lock.notifyAll();
        }
    }

    @Override
    public void second(Runnable printSecond) throws InterruptedException {
        synchronized(lock) {
            while (counter.get() != 1) {
                lock.wait();
            }

            printSecond.run();
            counter.incrementAndGet();
            lock.notifyAll();
        }

    }

    @Override
    public void third(Runnable printThird) throws InterruptedException {
        synchronized(lock) {
            while (counter.get() != 2) {
                lock.wait();
            }

            printThird.run();
            counter.incrementAndGet();
            lock.notifyAll();
        }

    }

}
