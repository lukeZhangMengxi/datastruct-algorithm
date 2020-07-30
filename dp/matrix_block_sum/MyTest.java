package dp.matrix_block_sum;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void simple() {
        int[][] input = new int[][] {
            new int[] {1,2,3},
            new int[] {4,5,6},
            new int[] {7,8,9}
        };
        int k = 1;
        int[][] expected = new int[][] {
            new int[] {12,21,16},
            new int[] {27,45,33},
            new int[] {24,39,28}
        };

        Solution s = new MySolution();
        int[][] out = s.matrixBlockSum(input, k);
        assertEquals(expected.length, out.length);
        for (int i=0; i<out.length; i++) {
            for (int j=0; j<out[0].length; j++)
                assertEquals(expected[i][j], out[i][j]);
        }
    }

}
