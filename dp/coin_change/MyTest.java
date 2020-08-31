package dp.coin_change;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lib.MyUnitTests;

public class MyTest extends MyUnitTests {
    @Test
    public void simple() {
        Solution s = new BF();

        assertEquals(3, s.coinChange(new int[] {1,2,5}, 11));
        assertEquals(-1, s.coinChange(new int[] {2}, 3));
    }

    @Test(timeout = 100)
    public void largerInput() {
        Solution s = new MEM();

        assertEquals(20, s.coinChange(new int[] {1,2,5}, 100));
    }

    @Test(timeout = 3000)
    public void evenLargerInput() {
        Solution s = new MEM();

        assertEquals(25, s.coinChange(new int[] {3, 7, 405, 436}, 8839));
    }
}
