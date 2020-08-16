package structure.two_d.two_d_array.min_path_sum;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            new BruteForce(),
            new TwoDDP()
        };
    }

    @Test
    public void simpleTestCase() {

        int[][] input = new int[][] {
            {1, 1, 1},
            {2, 2, 2},
            {3, 3, 3}
        };
        int expectedMinPathSum = 8;

        for (Solution method : methods) {
            int output = method.minPathSum(input);
        
            assertEquals(expectedMinPathSum, output);
        }

    }
}
