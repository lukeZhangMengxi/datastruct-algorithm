package multi_threads.concurrency.in_memory_cache;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class ConcurrentHashMapWorks {

    @Test
    public void entry_always_available_even_when_rehashing() throws InterruptedException {
        ConcurrentHashMap<Integer, String> cache = new ConcurrentHashMap<>();
        int READ_TIMES = 100000;
        int MAX_KEY = 100000;
        int PRE_EXIST_KEY = -19;

        cache.put(PRE_EXIST_KEY, "sOME VALUE");

        Thread reader = new Thread() {
            @Override
            public void run() {
                for (int i=0; i<READ_TIMES; i++) {
                    if (!cache.containsKey(PRE_EXIST_KEY)) {
                        System.out.println("We should not see this! PRE_EXIST_KEY was lost at iteration=" + i);
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
    public void concurrently_adding_entries_works() throws InterruptedException {
        class Key {}
        class Value {}
        ConcurrentHashMap<Key, Value> cache = new ConcurrentHashMap<>();

        int NUM_OF_WRITERS = 100;
        int NUM_OF_ADDING_PER_THREAD = 1000;

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
        assertEquals(expectedNum, cache.size());
        System.out.println("Expected entries added: " + expectedNum + ", while actually getting: " + cache.size());

    }
}
