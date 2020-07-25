package patterns.xor.find_missing_num;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    
    Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            new Regular(),
            new Xor()
        };
    }

    @Test
    public void simple() {
        for (Solution s: solutions) {
            assertEquals(3, s.findMissingNumber(new int[] {1, 5, 2, 6, 4}));
        }
    }

}
