package structure.two_d_array.min_path_sum;

class BruteForce implements Solution {

    @Override
    public int minPathSum(int[][] grid) {
        return calculate(grid, 0, 0);
    }

    private int calculate(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length-1 && j == grid[0].length-1) return grid[i][j];

        return grid[i][j] + Math.min(calculate(grid, i+1, j), calculate(grid, i, j+1));
    }
    
}
