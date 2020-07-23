package patterns.top_k_elements.top_k_nums;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    
    private Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            new PriorityQ()
        };
    }

    @Test
    public void simple() {
        int[] in = new int[] {5, 12, 11, -1, 12};
        int k = 3;
        Set<Integer> expected = new HashSet<>(Arrays.asList(11, 12));
        for (Solution s: solutions) {
            List<Integer> out = s.findKLargestNumbers(in, k);
            assertEquals(k, out.size());
            for (int v: out) {
                assert(expected.contains(v));
            }
        }
    }

}