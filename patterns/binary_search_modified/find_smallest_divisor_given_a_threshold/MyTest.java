package patterns.binary_search_modified.find_smallest_divisor_given_a_threshold;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import lib.TestUtils;

public class MyTest {

    Solution test = new Solution();

    int[] nums1 = new int[] { 1, 2, 5, 9 };
    int[] nums2;

    @Before
    public void init() throws FileNotFoundException {
        nums2 = TestUtils.readIntArrayFromSingleLineCommaSeparatedFile(
                "/Users/zhangmengxi/learning/datastruct-algorithm/patterns/binary_search_modified/find_smallest_divisor_given_a_threshold/nums2-threshold=83091.txt");
    }

    @Test
    public void computeTest1() {
        assertEquals(17, test.compute(nums1, 1));
        assertEquals(10, test.compute(nums1, 2));
        assertEquals(7, test.compute(nums1, 3));
        assertEquals(7, test.compute(nums1, 4));
        assertEquals(5, test.compute(nums1, 5));
    }

    @Test
    public void getRightTest1() {
        assertEquals(16, test.getRight(nums1, 4));
        assertEquals(8, test.getRight(nums1, 5));
        assertEquals(8, test.getRight(nums1, 6));
        assertEquals(4, test.getRight(nums1, 7));
        assertEquals(2, test.getRight(nums1, 10));
    }

    @Test
    public void binarySearchTest1() {
        // Regular case
        assertEquals(5, test.binarySearch(nums1, 6, 1, 8));
        assertEquals(3, test.binarySearch(nums1, 7, 1, 8));
        assertEquals(2, test.binarySearch(nums1, 10, 1, 8));
    }

    @Test
    public void smallestDivisorTest1() {
        assertEquals(5, test.smallestDivisor(nums1, 6));
        assertEquals(3, test.smallestDivisor(nums1, 7));
        assertEquals(2, test.smallestDivisor(nums1, 10));
    }

    @Test
    public void getRightTest2() {
        assertEquals(524288, test.getRight(nums2, 83091));
    }

    @Test
    public void smallestDivisorTest2() {
        assertEquals(445588, test.smallestDivisor(nums2, 83091));
    }
}
