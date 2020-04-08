package sort.k_closest_points_to_origin;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MyTest {
    @Test
    public void SimpleSortTest() {

        int[][] input = new int[][] {
            {1,1}, {2,2}, {3,3}, {4,4}, {5,5}
        };
        int k = 3;

        int[][] output = new SimpleSort().kClosest(input, k);
        
        for (int i=0; i<k; i++) {
            assertEquals(input[i][0], output[i][0]);
            assertEquals(input[i][1], output[i][1]);
        }

    }
}