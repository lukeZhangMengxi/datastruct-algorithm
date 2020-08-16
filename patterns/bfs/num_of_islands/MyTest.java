package patterns.bfs.num_of_islands;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void simple() {
        Solution s = new MS();

        assertEquals(
            3, 
            s.numIslands(new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
            })    
        );
    }
}
