package patterns.two_pointers.pair_with_target_sum;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            
        };
    }

    @Test
    public void simpleTestCase() throws Exception {

        int[] arr = new int[] {1, 2, 3, 4, 6};
        int target = 6;
        int[] expected = new int[] {1, 3};

        for (Solution method : methods) {
            int[] output = method.search(arr, target);
            assertEquals(2, output.length);
            assertEquals(expected[0], output[0]);
            assertEquals(expected[1], output[1]);
        }

    }
}
