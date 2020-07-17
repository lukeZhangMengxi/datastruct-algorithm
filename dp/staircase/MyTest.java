package dp.staircase;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    private Solution[] solutions;

    @Before
    public void init() {
        this.solutions = new Solution[] {
            new Recursion(),
            new Memoization()
        };
    }
    
    @Test
    public void simpleTestCase() {
        for (Solution m: solutions) {
            assertEquals(5, m.getCombination(4, 2));
        }
    }

}
