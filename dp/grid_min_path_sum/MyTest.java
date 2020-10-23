package dp.grid_min_path_sum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    
    Solution s = new Solution();

    @Test
    public void simple() {
        assertEquals(
            1, 
            s.minPathSum(new int[][] {
                {1,2,3},
                {-1,2,3},
                {1,-1,1}
            })  
        );
    }
}
