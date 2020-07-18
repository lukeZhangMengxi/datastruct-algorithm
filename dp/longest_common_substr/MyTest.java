package dp.longest_common_substr;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    private Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            // new Recursion(),
            // new Memoization(),
            new Tabulation()
        };
    }
    
    @Test
    public void simpleTestCase() {
        for (Solution s: solutions) {
            // assertEquals(2, s.getMaxCommonSubstrLen("abc", "bc"));
            assertEquals(7, s.getMaxCommonSubstrLen("eqhello yelf", "hello yourself"));
        }
    }
}