package java_lang_interface.java_util.timer;

import org.junit.Test;

import java.util.Timer;
import java.util.TimerTask;

public class MyTest {

    class Target {
        // Timer timer;
        public Target() {
            Timer timer = new Timer();
            timer.schedule(new TimerTask(){
                @Override
                public void run() {
                    System.out.println("I am running!!!");
                }
            }, 0, 1*1000);
        }
    }

    @Test
    public void simple() throws InterruptedException {
        new Target();
        Thread.currentThread();
        Thread.sleep(5000);
    }
}
