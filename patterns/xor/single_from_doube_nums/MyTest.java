package patterns.xor.single_from_doube_nums;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            new UseMap(),
            new UseXor()
        };
    }

    @Test
    public void simple() {
        for (Solution s : solutions) {
            assertEquals(4, s.findSingleNumber(new int[] {1, 4, 2, 1, 3, 2, 3}));
        }
    }

}
