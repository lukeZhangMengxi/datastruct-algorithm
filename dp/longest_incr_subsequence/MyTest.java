package dp.longest_incr_subsequence;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            new Recursion(),
            new Memoization()
        };
    }

    @Test
    public void simpleTestCase() {
        for (Solution s: solutions) {
            assertEquals(
                4, 
                s.lenOfLongestIncrSubsequence(
                    new int[] {10, 9, 2, 5, 3, 7, 101, 18}
                )
            );
        }
    }
    
}