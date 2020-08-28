package dp.stock_buy_sell2;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import lib.MyUnitTests;
import lib.TestUtils;

public class MyTest extends MyUnitTests {

    int[] input1000, input26004;
    int expected1000, expected26004;

    Solution BRUTE_FORCE, MEMOIZATION;

    @Before
    public void init() throws FileNotFoundException {
        input1000 = TestUtils.readIntArrayFromSingleLineCommaSeparatedFile(
            "/Users/zhangmengxi/learning/datastruct-algorithm/dp/stock_buy_sell2/input1000.txt"
        );
        input26004 = TestUtils.readIntArrayFromSingleLineCommaSeparatedFile(
            "/Users/zhangmengxi/learning/datastruct-algorithm/dp/stock_buy_sell2/input26004.txt"
        );

        BRUTE_FORCE = new BruteForceDFS();
        MEMOIZATION = new Memoization();
    }

    @Test
    public void simple() {
        for (Solution s: Arrays.asList(BRUTE_FORCE, MEMOIZATION)) {
            assertEquals(7, s.maxProfit(new int[] {7,1,5,3,6,4}));
            assertEquals(4, s.maxProfit(new int[] {1,2,3,4,5}));
            assertEquals(0, s.maxProfit(new int[] {7,6,4,3,1}));
        }
    }

    @Test(timeout = 10000)
    public void bruteForce10SecTimeoutInput1000() {
        BRUTE_FORCE.maxProfit(input1000);
    }

    @Test(timeout = 1000)
    public void memoizationPassInput1000() {
        assertEquals(1697678, MEMOIZATION.maxProfit(input1000));
    }

    @Test(expected = StackOverflowError.class)
    public void memoizationStackOverflowInput26004() {
        MEMOIZATION.maxProfit(input26004);
    }

}