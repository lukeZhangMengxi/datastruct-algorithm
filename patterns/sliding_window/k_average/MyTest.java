package patterns.sliding_window.k_average;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            new BruteForce()
        };
    }

    @Test
    public void simpleTestCase() throws Exception {

        int[] arr = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int k = 5;
        double[] expected = new double[] {2.2, 2.8, 2.4, 3.6, 2.8};

        for (Solution method : methods) {
            double[] output = method.findAverages(k, arr);

            for (int i=0; i<output.length; i++)
                assert(expected[i] == output[i]);
        }

    }

}