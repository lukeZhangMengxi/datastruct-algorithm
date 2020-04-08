package stream.max_sum_subarray;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            new DivideConquer(),
            new HardDP(),
            new GreedyVariable()
        };
    }

    @Test
    public void simpleTestCase() {

        int[] input = new int[] {1, 23, -4, 5, 6};
        int expected = 31;

        for (Solution method : methods) {
            int output = method.maxSubArray(input);

            assertEquals(expected, output);
        }

    }
}
