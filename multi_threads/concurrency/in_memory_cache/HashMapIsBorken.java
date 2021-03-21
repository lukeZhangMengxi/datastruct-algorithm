package multi_threads.concurrency.in_memory_cache;

import static org.junit.Assert.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class HashMapIsBorken {

    @Test
    public void entry_not_available_when_rehashing() throws InterruptedException {
        Map<Integer, String> cache = new HashMap<>();
        int READ_TIMES = 10000;
        int MAX_KEY = 10000;
        int PRE_EXIST_KEY = -19;

        cache.put(PRE_EXIST_KEY, "sOME VALUE");

        Thread reader = new Thread() {
            @Override
            public void run() {
                for (int i=0; i<READ_TIMES; i++) {
                    if (!cache.containsKey(PRE_EXIST_KEY)) {
                        System.out.println("PRE_EXIST_KEY was lost at iteration=" + i);
                    }
                }
            }
        };

        Thread writer = new Thread() {
            @Override
            public void run() {
                for (int k=0; k<MAX_KEY; k++) { cache.put(k, "value"); }
            }
        };

        reader.start();
        writer.start();
        reader.join();
        writer.join();
    }

    @Test
    public void concurrently_adding_entries_lost() throws InterruptedException {
        class Key {}
        class Value {}
        Map<Key, Value> cache = new HashMap<>();

        int NUM_OF_WRITERS = 10;
        int NUM_OF_ADDING_PER_THREAD =100;

        Thread[] writers = new Thread[NUM_OF_WRITERS];
        for (int i=0; i<writers.length; i++) {
            writers[i] = new Thread() {
                @Override
                public void run() {
                    for (int k=0; k<NUM_OF_ADDING_PER_THREAD; k++) cache.put(new Key(), new Value());
                }
            };
        }

        for (Thread w : writers) { w.start(); }
        for (Thread w : writers) { w.join(); }

        int expectedNum = NUM_OF_WRITERS * NUM_OF_ADDING_PER_THREAD;
        assertNotEquals(expectedNum, cache.size());
        System.out.println("Expected entries added: " + expectedNum + ", while actually getting: " + cache.size());

    }
}
