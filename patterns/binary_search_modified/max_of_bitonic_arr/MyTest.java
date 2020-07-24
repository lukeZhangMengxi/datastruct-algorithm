package patterns.binary_search_modified.max_of_bitonic_arr;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    
    Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            new LinearSearch(),
            new BinarySearch()
        };
    }

    @Test
    public void simple() {
        for (Solution s: solutions) {
            assertEquals(12, s.findMax(new int[] {1, 3, 8, 12, 4, 2}));
            assertEquals(12, s.findMax(new int[] {1, 3, 8, 12}));
            assertEquals(3, s.findMax(new int[] {3, 2, 1}));
            assertEquals(-1, s.findMax(new int[] {}));
        }
    }

}
