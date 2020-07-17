package dp.knapsack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    private Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            new Recursion(),
            new Memoization()
        };
    }
    
    @Test
    public void simpleTestCase() {
        for (Solution m: solutions) {
            assertEquals(
                11,
                m.maxProfit(
                    new int[] {1, 2, 4, 6},
                    new int[] {4, 2, 4, 7},
                    7
                )
            );
        }
    }

}
