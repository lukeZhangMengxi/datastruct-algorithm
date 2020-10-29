package patterns.prefix_sum.queries_rearrange_substr_palinfrome;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import lib.TestUtils;

@SuppressWarnings("serial")
public class MyTest {

    Solution test = new Solution();

    String s1 = "abcda";
    int[][] prefixSum1 = test.generatePrefixSum(s1);

    @Test
    public void genPrefixSumTest() {
        int[][] expected = new int[][] {
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

        int[][] actual = test.generatePrefixSum(s1);

        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void canMakePalindromeTest1() {
        assertTrue(test.canMakePalindrome(s1, 3, 3, 0, prefixSum1, null));
        assertFalse(test.canMakePalindrome(s1, 1, 2, 0, prefixSum1, null));
        assertFalse(test.canMakePalindrome(s1, 0, 3, 1, prefixSum1, null));
        assertTrue(test.canMakePalindrome(s1, 0, 3, 2, prefixSum1, null));
        assertTrue(test.canMakePalindrome(s1, 0, 4, 1, prefixSum1, null));

        // Result depends on cache when cache is not NULL and key exits
        assertTrue(test.canMakePalindrome(s1, 3, 3, 0, prefixSum1, new HashMap<>() {
            {
                this.put("3#3", 0);
            }
        }));
        assertFalse(test.canMakePalindrome(s1, 3, 3, 0, prefixSum1, new HashMap<>() {
            {
                this.put("3#3", 2);
            }
        }));
    }

    @Test
    public void canMakePaliQueriesTest1() {

        List<Boolean> actual = test.canMakePaliQueries(s1, new int[][] {
            {3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}
        });
        
        TestUtils.assertListEquals(
            Arrays.asList(true,false,false,true,true),
            actual
        );
    }
}
