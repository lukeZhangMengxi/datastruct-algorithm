package structure.two_d.two_d_array.min_path_sum;

public class TwoDDP implements Solution {

    @Override
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i=0; i<dp.length; i++) {
            for (int j=0; j<dp[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) dp[i][j] = dp[i][j-1] + grid[i][j];
                else if (j == 0) dp[i][j] = dp[i-1][j] + grid[i][j];
                else dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

}