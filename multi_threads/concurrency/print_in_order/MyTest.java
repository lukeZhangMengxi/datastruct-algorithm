package multi_threads.concurrency.print_in_order;

import org.junit.Test;

public class MyTest {
    @Test
    public void simple() throws InterruptedException {
        // Solution s = new UsePairSynchronization();
        Solution s = new UseMonitorLock();
        s.init();

        Thread one = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s.first(() -> {
                        System.out.println("first");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread two = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s.second(() -> {
                        System.out.println("second");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread three = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s.third(() -> {
                        System.out.println("third");
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        two.start();
        three.start();
        one.start();

        one.join(1,000);
        two.join(1,000);
        three.join(1,000);
        
    }
}
