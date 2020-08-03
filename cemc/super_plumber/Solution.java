package cemc.super_plumber;

import java.util.HashMap;
import java.util.Map;

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

class DFSBacktrackReducedContext implements Solution {

    private int dfs(char[][] grid, int r, int c, int lastR, int lastC) {
        if (r<0 || c <0 || r>=grid.length || c>=grid[0].length) return -1;
        if (grid[r][c] == '*') return Integer.MIN_VALUE;

        int curScore = (grid[r][c] == '.') ? 0 : Character.getNumericValue(grid[r][c]);
        if (r == grid.length-1 && c == grid[0].length-1) return curScore;
        
        int maxRestScore = Integer.MIN_VALUE;
        if (r+1 != lastR || c != lastC) maxRestScore = dfs(grid, r+1, c, r, c);
        if (r-1 != lastR || c != lastC) maxRestScore = Math.max(maxRestScore, dfs(grid, r-1, c, r, c));
        if (r != lastR || c+1 != lastC) maxRestScore = Math.max(maxRestScore, dfs(grid, r, c+1, r, c));

        return curScore + maxRestScore;
    }

    @Override
    public int getMaxScore(char[][] grid) {
        
        return dfs(grid, grid.length-1, 0, -1, -1);
    }

}

class Memoization implements Solution {

    private String encodeKey(int r, int c, int lastR, int lastC) {
        return r + "#" + c + "#" + lastR + "#" + lastC + "#";
    }

    private int dfs(char[][] grid, int r, int c, int lastR, int lastC, Map<String, Integer> dp) {
        if (r<0 || c <0 || r>=grid.length || c>=grid[0].length) return -1;
        if (grid[r][c] == '*') return Integer.MIN_VALUE;

        String dpKey = encodeKey(r, c, lastR, lastC);
        if (dp.containsKey(dpKey)) return dp.get(dpKey);

        int curScore = (grid[r][c] == '.') ? 0 : Character.getNumericValue(grid[r][c]);
        if (r == grid.length-1 && c == grid[0].length-1) return curScore;
        
        int maxRestScore = Integer.MIN_VALUE;
        if (r+1 != lastR || c != lastC) maxRestScore = dfs(grid, r+1, c, r, c, dp);
        if (r-1 != lastR || c != lastC) maxRestScore = Math.max(maxRestScore, dfs(grid, r-1, c, r, c, dp));
        if (r != lastR || c+1 != lastC) maxRestScore = Math.max(maxRestScore, dfs(grid, r, c+1, r, c, dp));

        dp.put(dpKey, curScore + maxRestScore);
        return curScore + maxRestScore;
    }

    @Override
    public int getMaxScore(char[][] grid) {
        
        return dfs(grid, grid.length-1, 0, -1, -1, new HashMap<>());
    }

}
