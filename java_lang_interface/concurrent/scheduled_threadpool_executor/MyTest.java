package java_lang_interface.concurrent.scheduled_threadpool_executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

class BeepTask implements Runnable {

    public void run() {
        System.out.println("beep");
    }
}

public class MyTest {

    @Test
    public void simple() throws InterruptedException {
        final ScheduledThreadPoolExecutor scheduler = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);

        final ScheduledFuture<?> beepHandler = scheduler.scheduleAtFixedRate(new BeepTask(), 2, 2, TimeUnit.SECONDS);

        CountDownLatch latch = new CountDownLatch(1);

        scheduler.schedule(new Runnable() {

            @Override
            public void run() {
                beepHandler.cancel(true);
                scheduler.shutdown();
                latch.countDown();
            }
        }, 10, TimeUnit.SECONDS);

        latch.await(2, TimeUnit.MINUTES);
        System.out.println("I am DONE!!!");
    }
}
