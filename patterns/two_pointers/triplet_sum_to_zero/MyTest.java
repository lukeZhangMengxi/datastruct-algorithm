package patterns.two_pointers.triplet_sum_to_zero;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            // new BruteForce(),
            new PointerWithSlidingWindow()
        };
    }

    @Test
    public void simpleTestCase() throws Exception {

        int[] arr = new int[] {-3, 0, 1, 2, -1, 1, -2};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(-3, 1, 2),
            Arrays.asList(-2, 0, 2),
            Arrays.asList(-2, 1, 1),
            Arrays.asList(-1, 0, 1)
        );

        for (Solution method : methods) {
            List<List<Integer>> output = method.searchTriplets(arr);
            Collections.sort(output, (a, b) -> a.get(0) - b.get(0));

            assertEquals(expected.size(), output.size());
            for (int i=0; i<expected.size(); i++) {
                for (int j=0; j<3; j++) {
                    assertEquals(expected.get(i).get(j), output.get(i).get(j));
                }
            }
        }

    }
}
