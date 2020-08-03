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

    private final int RIGHT = 0;
    private final int UP = 1;
    private final int DOWN = 2;


    private String encodeKey(int r, int c, int last) {
        return r + "#" + c + "#" + last;
    }

    private int dfs(char[][] grid, int r, int c, int last, Map<String, Integer> dp) {
        if (r<0 || c <0 || r>=grid.length || c>=grid[0].length) return -1;
        if (grid[r][c] == '*') return Integer.MIN_VALUE;

        String dpKey = encodeKey(r, c, last);
        if (dp.containsKey(dpKey)) return dp.get(dpKey);

        int curScore = (grid[r][c] == '.') ? 0 : Character.getNumericValue(grid[r][c]);
        if (r == grid.length-1 && c == grid[0].length-1) return curScore;
        
        int maxRestScore = Integer.MIN_VALUE;
        if (last != DOWN) maxRestScore = dfs(grid, r+1, c, UP, dp);
        if (last != UP) maxRestScore = Math.max(maxRestScore, dfs(grid, r-1, c, DOWN, dp));
        maxRestScore = Math.max(maxRestScore, dfs(grid, r, c+1, RIGHT, dp));

        dp.put(dpKey, curScore + maxRestScore);
        return curScore + maxRestScore;
    }

    @Override
    public int getMaxScore(char[][] grid) {
        
        return dfs(grid, grid.length-1, 0, RIGHT, new HashMap<>());
    }

}
