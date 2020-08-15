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
