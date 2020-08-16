package patterns.bfs.num_of_islands;

interface Solution {
    int numIslands(char[][] grid);
}

class MS implements Solution {

    private void cleanLand(char[][] grid, int i, int j) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length) return;

        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            cleanLand(grid, i+1, j);
            cleanLand(grid, i-1, j);
            cleanLand(grid, i, j+1);
            cleanLand(grid, i, j-1);
        }
    }

    @Override
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;

        int rst = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    rst++;
                    cleanLand(grid, i, j);
                }
            }
        }

        return rst;
    }

}
