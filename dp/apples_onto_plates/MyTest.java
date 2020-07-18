package dp.apples_onto_plates;

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
                8, 
                s.count(7, 3)
            );
        }
    }

}