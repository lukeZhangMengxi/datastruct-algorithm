package patterns.top_k_elements.kth_largest_element;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void simple() {
        Solution s = new QuickSelect();

        assertEquals(5, s.findKthLargest(new int[] {3,2,1,5,6,4}, 2));
        assertEquals(4, s.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }
}
