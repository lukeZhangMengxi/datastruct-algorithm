package patterns.cyclic_sort.cyclic_sort;

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
        int[] input = new int[] {2, 6, 4, 3, 1, 5};
        int[] expected = new int[] {1, 2, 3, 4, 5, 6};

        for (Solution m: methods) {
            m.sort(input);
            assertEquals(expected.length, input.length);
            for (int i=0; i<input.length; i++)
                assertEquals(expected[i], input[i]);
        }
    }
}
