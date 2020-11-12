package patterns.linked_hashmap.lru;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {

    @Test
    public void simple() {
        Solution cache = new Solution(1);

        cache.put(2, 1);
        assertEquals(1, cache.get(2));

        cache.put(3, 2);
        assertEquals(-1, cache.get(2));
        assertEquals(2, cache.get(3));
    }

    @Test
    public void simple1() {
        Solution cache = new Solution(2);

        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.get(2));
    }
}
