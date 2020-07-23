package patterns.top_k_elements.top_k_frequent_num;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class MyTest {

    @Test
    public void simple() {
        Solution s = new PriorityQ();

        List<Integer> out = s.findTopKFrequentNumbers(
            new int[] {1, 3, 5, 12, 11, 12, 11},
            2
        );
        Collections.sort(out);

        List<Integer> expected =Arrays.asList(11, 12);
        for (int i=0; i<out.size(); i++) {
            assertEquals(expected.get(i), out.get(i));
        }
    }

}
