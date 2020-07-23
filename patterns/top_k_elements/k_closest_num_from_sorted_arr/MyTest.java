package patterns.top_k_elements.k_closest_num_from_sorted_arr;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    
    private Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            new BinarySAndPriorityQ()
        };
    }

    @Test
    public void simple() {
        int[] in = new int[] {2, 4, 5, 6, 9};
        int k = 3, x = 6;
        int[] expected = new int[] {4, 5, 6};

        for (Solution s: solutions) {
            List<Integer> out = s.findClosestElements(in, k, x);
            assertEquals(expected.length, out.size());
            for (int i=0; i<out.size(); i++) assertEquals(expected[i], (int)out.get(i));
        }
    }

}
