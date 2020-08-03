package cemc.super_plumber;

interface Solution {
    int getMaxScore(char[][] grid);
}

class DFSBacktrack implements Solution {

    private int dfs(char[][] grid, int r, int c, boolean[][] visited) {
        if (r<0 || c <0 || r>=grid.length || c>=grid[0].length) return -1;
        if (grid[r][c] == '*' || visited[r][c]) return Integer.MIN_VALUE;

        int curScore = (grid[r][c] == '.') ? 0 : Character.getNumericValue(grid[r][c]);
        if (r == grid.length-1 && c == grid[0].length-1) return curScore;

        visited[r][c] = true;
        
        int maxRestScore = dfs(grid, r+1, c, visited);
        maxRestScore = Math.max(maxRestScore, dfs(grid, r-1, c, visited));
        maxRestScore = Math.max(maxRestScore, dfs(grid, r, c+1, visited));

        visited[r][c] = false;

        return curScore + maxRestScore;
    }

    @Override
    public int getMaxScore(char[][] grid) {
        
        return dfs(grid, grid.length-1, 0, new boolean[grid.length][grid[0].length]);
    }

}
