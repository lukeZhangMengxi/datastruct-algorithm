package patterns.bfs.rotting_oranges;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    Solution s = new BruteForce();

    @Test
    public void simple() {
        assertEquals(4, s.orangesRotting(new int[][] {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        }));
    }

    @Test
    public void simple2() {
        assertEquals(1, s.orangesRotting(new int[][] {
            {1,2}
        }));
    }

    @Test
    public void notPossible() {
        assertEquals(-1, s.orangesRotting(new int[][] {
            {2,1,1},
            {0,1,1},
            {1,0,1}
        }));
    }
}
