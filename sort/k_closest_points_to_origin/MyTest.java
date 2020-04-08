package sort.k_closest_points_to_origin;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            new SimpleSort(),
            new FixLengthPriorityQueue(),
            new QuickSort()
        };
    }

    @Test
    public void linerTestCase() {

        int[][] input = new int[][] {
            {1,1}, {2,2}, {3,3}, {4,4}, {5,5}
        };
        int k = 3;

        Set<Integer> expected = new HashSet<Integer>() {{add(1); add(2); add(3);}};

        for (Solution method : methods) {
            int[][] outputs = method.kClosest(input, k);
        
            for (int[] output: outputs) {
                assertTrue(expected.contains(output[0]));
                assertTrue(expected.contains(output[1]));
            }
        }

    }
}