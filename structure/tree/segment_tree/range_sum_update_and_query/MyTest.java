package structure.tree.segment_tree.range_sum_update_and_query;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void simple() {
        Solution s = new UseSegmengTree();

        s.init(new int[] {1,3,5});
        assertEquals(8, s.rangeSum(1, 2));
        assertEquals(9, s.rangeSum(0, 2));
        s.update(2, 2);
        assertEquals(5, s.rangeSum(1, 2));
        assertEquals(6, s.rangeSum(0, 2));
    }
}
