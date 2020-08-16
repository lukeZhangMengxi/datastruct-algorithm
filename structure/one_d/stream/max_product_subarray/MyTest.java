package structure.one_d.stream.max_product_subarray;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            new HardDP(),
            new GreedyVariables()
        };
    }

    @Test
    public void simpleTestCase() {

        int[] input = new int[] {1, 23, -4, 5, 6};
        int expected = 30;

        for (Solution method : methods) {
            int output = method.maxProduct(input);

            assertEquals(expected, output);
        }

    }
}
