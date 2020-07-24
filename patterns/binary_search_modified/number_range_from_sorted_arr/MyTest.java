package patterns.binary_search_modified.number_range_from_sorted_arr;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            new BinarySearch()
        };
    }

    @Test
    public void simple() {
        for (Solution s: solutions) {
            int[] out = s.findRange(new int[] {4, 6, 6, 6, 9}, 6);
            assertEquals(out[0], 1);
            assertEquals(out[1], 3);

            out = s.findRange(new int[] {1, 3, 8, 10, 15}, 10);
            assertEquals(out[0], 3);
            assertEquals(out[1], 3);

            out = s.findRange(new int[] {1, 3, 8, 10, 15}, 12);
            assertEquals(out[0], -1);
            assertEquals(out[1], -1);
        }
    }
}