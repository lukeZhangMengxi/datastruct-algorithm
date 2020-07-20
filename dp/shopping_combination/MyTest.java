package dp.shopping_combination;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    
    private Solution[] solutions;

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
                3100, 
                s.getMaxWeightedValue(
                    new int[][] {
                        new int[] {800, 2, 0},
                        new int[] {400, 5, 1},
                        new int[] {300, 5, 1},
                        new int[] {400, 3, 0},
                        new int[] {500, 2, 0}
                    },
                    1100
                )
            );

            assertEquals(
                2200, 
                s.getMaxWeightedValue(
                    new int[][] {
                        new int[] {800, 2, 0},
                        new int[] {400, 5, 1},
                        new int[] {300, 5, 1},
                        new int[] {400, 3, 0},
                        new int[] {500, 2, 0}
                    },
                    900
                )
            );
        }
    }

}