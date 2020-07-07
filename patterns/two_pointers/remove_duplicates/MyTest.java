package patterns.two_pointers.remove_duplicates;

import static org.junit.Assert.assertEquals;
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
            new TwoPoints()
        };
    }

    @Test
    public void simpleTestCase() throws Exception {

        int[] arr = new int[] {2, 3, 3, 3, 6, 9, 9};
        int expected = 4;

        for (Solution method : methods) {
            assertEquals(expected, method.remove(arr));
            assertTrue(noDuplicates(arr, expected));
        }

    }

    private boolean noDuplicates(int[] arr, int range) {
        Set<Integer> s = new HashSet<>();
        for (int i=0; i<range; i++)
            s.add(arr[i]);
        return s.size() == range;
    }
}
