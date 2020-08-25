package patterns.merge_intervals.label_partition;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import lib.TestUtils;

public class MyTest {
    @Test
    public void simple() {
        Solution s = new MS();
        
        List<Integer> r = s.partitionLabels("ababcbacadefegdehijhklij");
        TestUtils.assertListEquals(
            Arrays.asList(9,7,8),
            r  
        );
        
    }
}
