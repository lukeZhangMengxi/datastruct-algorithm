package patterns.binary_search_modified.order_agnostic_binary_search;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    
    private Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            new BinarySearch()
        };
    }

    @Test
    public void simpleIncrasingCase() {
        for (Solution s: solutions) {
            assertEquals(4, s.searchIndex(new int[] {1, 2, 3, 4, 5, 6, 7}, 5));
        }
    }

    @Test
    public void simpleDecreasingCase() {
        for (Solution s: solutions) {
            assertEquals(0, s.searchIndex(new int[] {10, 6, 4}, 10));
        }
    }

    @Test
    public void notFoundCase() {
        for (Solution s: solutions) {
            assertEquals(-1, s.searchIndex(new int[] {10, 6, 4}, 5));
        }
    }
}
