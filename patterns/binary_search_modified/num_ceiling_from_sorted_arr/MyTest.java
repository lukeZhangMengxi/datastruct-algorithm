package patterns.binary_search_modified.num_ceiling_from_sorted_arr;

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
            assertEquals(
                1,
                s.searchCeilingOfANumber(new int[] {4, 6, 10}, 6)
            );

            assertEquals(
                4,
                s.searchCeilingOfANumber(new int[] {1, 3, 8, 10, 15}, 12)
            );

            assertEquals(
                -1,
                s.searchCeilingOfANumber(new int[] {4, 6, 10}, 17)
            );

            assertEquals(
                0,
                s.searchCeilingOfANumber(new int[] {4, 6, 10}, -5)
            );
        }
    }

}
