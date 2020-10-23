package dp.grid_min_path_sum;

public class Solution {

    int minPathSum(int[][] grid) {
        Integer[][] map = new Integer[grid.length][grid[0].length];

        for (int i=0; i<grid.length; i++) {
            map[i][0] = i==0 ? grid[0][0] : map[i-1][0] + grid[i][0];
        }

        for (int j=0; j<grid[0].length; j++) {
            map[0][j] = j==0 ? grid[0][0] : map[0][j-1] + grid[0][j];
        }

        for (int i=1; i<grid.length; i++) {
            for (int j=1; j<grid[0].length; j++) {
                map[i][j] = Math.min(map[i-1][j], map[i][j-1]) + grid[i][j];
            }
        }

        return map[map.length-1][map[0].length-1];
    }    
}
