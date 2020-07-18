package dp.currency_bill_combination;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    private Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            // new BruteForceRecursion(),
            // new SimpleRecursion(),
            new Memoization()
        };
    }
    
    @Test
    public void simpleTestCase() {
        for (Solution s: solutions) {
            assertEquals(
                3,
                s.getNumOfCombinations(
                    new int[] {10, 20},
                    50
                )
            );
        }
    }

}
