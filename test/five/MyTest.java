package test.five;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void simpleTestCase() {
        Solution m = new BacktrackDFS();
        assertEquals(3, m.getMaxSteps(new int[] {2, 5, 1, 5, 4, 5}));
    }
}
