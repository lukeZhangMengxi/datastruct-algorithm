package dp.knapsack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import lib.MyUnitTests;

public class MyTest extends MyUnitTests {

    private Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            // new Recursion()
            // new Memoization()
            // new Tabulation()
            new SpaceReducedTabulation()
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

    @Test
    public void largeInput() {
        int[] weights = new int[] {28,41,21,48,85,80,39,46,21,97,67,79,26,14,95,12,89,18,52,52,12,88,61,69,48,48,62,74,11,5,3,38,12,53,80,90,16,65,44,25,41,53,58,38,4,72,55,44,30,42,5,9,21,24,85,59,44,59,8,29,41,44,4,26,63,99,18,70,38,47,23,90,19,24,34,31,57,46,36,96,54,75,93,21,83,36,42,2,43,85,21,57,23,96,64,49,91,96,10};
        int[] profits = new int[] {60,20,16,42,83,68,85,69,88,48,29,59,18,53,7,15,18,53,93,57,93,63,49,68,70,19,62,81,60,96,92,89,45,28,61,83,10,52,52,34,16,18,64,20,14,86,65,27,33,49,21,3,78,46,11,81,53,70,92,23,50,7,51,48,58,90,65,21,60,89,91,37,33,72,26,3,67,92,46,30,0,30,0,78,11,71,60,4,79,34,8,82,39,64,71,46,17,58,7};
        for (Solution m: solutions) {
            assertEquals(
                899,
                m.maxProfit(
                    weights,
                    profits,
                    150     // Increase this value to allow DFS goes deeper, and the recursion would be much much slower
                )
            );
        }
    }

}
