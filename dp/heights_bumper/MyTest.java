package dp.heights_bumper;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    
    Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            // new Recursion(),
            new Memoization()
        };
    }

    @Test
    public void simpleTestCase() {
        for (Solution s: solutions) {
            assertEquals(
                4, 
                s.numToRemoveToFormPike(
                    // new int[] {1, 7, 3, 5, 2, 1, 2}
                    new int[] {186, 186, 150, 200, 160, 130, 197, 200}
                )
            );
        }
    }

}