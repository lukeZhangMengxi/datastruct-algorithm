package patterns.sliding_window.max_len_k_distinct_char;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            // new BruteForce(),
            new ReuseSubstrCount()
        };
    }

    @Test
    public void simpleTestCase() throws Exception {

        String str = "araaci";
        int[] k = new int[] {1, 2};
        int[] expected = new int[] {2, 4};

        for (Solution method : methods) {
            for (int i=0; i<k.length; i++) {
                assertEquals(expected[i], method.findLength(str, k[i]));
            }
        }

    }
}
