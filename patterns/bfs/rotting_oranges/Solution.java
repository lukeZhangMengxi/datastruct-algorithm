package patterns.bfs.rotting_oranges;

import java.util.HashSet;
import java.util.Set;

interface Solution {
    int orangesRotting(int[][] grid);
}

class BruteForce implements Solution {

    boolean noFresh(int[][] grid) {
        for (int[] r: grid) {
            for (int v: r) {
                if (v == 1) return false;
            }
        }
        return true;
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) return false;
            if (!(obj instanceof Point)) return false;
            return this.x == ((Point)obj).x && this.y == ((Point)obj).y;
        }

        @Override
        public int hashCode() {
            return (x + ":" + y).hashCode();
        }
    }

    int rot(int[][] g, Set<Point> buf, int i, int j) {
        if (i<0 || j<0 || i>= g.length || j>=g[0].length) return 0;
        
        if (g[i][j] == 1) {
            Point p = new Point(i, j);
            if (!buf.contains(p)) {
                buf.add(p);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        Integer counter = null;
        Set<Point> buf = new HashSet<>();

        while (counter == null || counter != 0) {
            counter = 0;
            buf.clear();

            // Find fresh to rot at this time
            for (int i=0; i<grid.length; i++) {
                for (int j=0; j<grid[0].length; j++) {
                    if (grid[i][j] == 2) {
                        counter += rot(grid, buf, i+1, j);
                        counter += rot(grid, buf, i-1, j);
                        counter += rot(grid, buf, i, j+1);
                        counter += rot(grid, buf, i, j-1);
                    }
                }
            }

            // Rot them
            for (Point p: buf) {
                grid[p.x][p.y] = 2;
            }
            minutes++;
        }
        minutes--;  // it takes one more minute to decide loop's termination

        return noFresh(grid) ? minutes : -1;
    }

}
