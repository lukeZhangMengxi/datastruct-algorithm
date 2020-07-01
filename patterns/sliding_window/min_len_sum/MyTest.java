package patterns.sliding_window.min_len_sum;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyTest {
    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            new BruteForce(),
            new ReuseSubarraySum()
        };
    }

    @Test
    public void simpleTestCase() throws Exception {

        int[] arr = new int[] {2, 1, 5, 2, 3, 2};
        int[] s = new int[] {8, 4};
        int[] expected = new int[] {3, 1};

        for (Solution method : methods) {
            for (int i=0; i<s.length; i++) {
                assertEquals(expected[i], method.findMinSubArray(s[i], arr));
            }
        }

    }

    @Test
    public void noAvailableResult() throws Exception {
        int[] arr = new int[] {2, 1, 5, 2, 3, 2};
        for (Solution method : methods)
            assertEquals(-1, method.findMinSubArray(999, arr));
    }

    @Test
    public void badParameter() throws Exception {
        int[] badArr = new int[] {2, 1, -5, 2, 3, 2};
        for (Solution method : methods) {
            try {
                method.findMinSubArray(3, badArr);
                Assert.fail("Bad parameters should throws exception!");
            } catch (Exception e) {
                assert(e.getMessage().compareTo("Array contains negative value!") == 0);
            }
        }

    }
}