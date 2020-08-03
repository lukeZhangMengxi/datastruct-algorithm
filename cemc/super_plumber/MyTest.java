package cemc.super_plumber;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void simple() {
        Solution s = new DFSBacktrack();
        assertEquals(
            27, 
            s.getMaxScore(
                new char[][] {
                    new char[] {'.','.','3','.','.','.','.','.','.','.'},
                    new char[] {'.','.','.','.','.','.','.','.','.','.'},
                    new char[] {'.','.','7','.','*','*','.','.','.','.'},
                    new char[] {'.','9','*','*','.','.','.','1','.','.'},
                    new char[] {'.','.','8','.','.','9','.','.','.','.'}
                }
            )
        );
    }

    @Test
    public void simple2() {
        Solution s = new DFSBacktrack();
        assertEquals(
            34, 
            s.getMaxScore(
                new char[][] {
                    new char[] {'9','9'},
                    new char[] {'8','8'}
                }
            )
        );
    }
}