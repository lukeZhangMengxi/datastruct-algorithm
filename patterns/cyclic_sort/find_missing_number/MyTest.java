package patterns.cyclic_sort.find_missing_number;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class MyTest {

    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            new CyclicSort()
        };
    }

    @Test
    public void simpleTestCase() throws Exception {
        int[] input = new int[] {8, 3, 5, 2, 4, 6, 0, 1};
        int expected = 7;
        for (Solution m: methods) {
            assertEquals(expected, m.findMissingNumber(input));
        }
    }
}
