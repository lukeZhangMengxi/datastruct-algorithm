package patterns.sliding_window.k_max_sum;

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

        int[] arr = new int[] {2, 1, 5, 1, 3, 2};
        int[] k = new int[] {3, 2};
        int[] expected = new int[] {9, 7};

        for (Solution method : methods) {
            for (int i=0; i<k.length; i++) {
                assertEquals(expected[i], method.findMaxSumSubArray(k[i], arr));
            }
        }

    }
}