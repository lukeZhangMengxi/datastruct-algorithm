package dp.decode_ways;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void simple() {
        Solution s = new BBF();

        assertEquals(2, s.numDecodings("12"));
        assertEquals(3, s.numDecodings("226"));
        assertEquals(1, s.numDecodings("101"));
    }

    @Test(timeout = 100)
    public void input100() {
        Solution s = new Memoization();
        String in = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
        int expected = 3981312;

        assertEquals(expected, s.numDecodings(in));
    }

    @Test(timeout = 100)
    public void anotherInput100() {
        Solution s = new Memoization();
        String in = "1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565";
        int expected = 5898240;

        assertEquals(expected, s.numDecodings(in));
    }

}
