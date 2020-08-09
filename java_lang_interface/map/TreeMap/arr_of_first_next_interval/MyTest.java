package java_lang_interface.map.TreeMap.arr_of_first_next_interval;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MyTest {

    @Test
    public void simple() {
        Solution s = new SortBinarySearch();

        assertArrayEquals(
            new int[] {-1},
            s.findRightInterval(new int[][] {new int[] {1,2}})    
        );

        assertArrayEquals(
            new int[] {-1,0,1},
            s.findRightInterval(new int[][] {
                new int[] {3,4}, new int[] {2,3}, new int[] {1,2}
            })    
        );

        assertArrayEquals(
            new int[] {-1,0,0},
            s.findRightInterval(new int[][] {
                new int[] {3,4}, new int[] {2,3}, new int[] {1,3}
            })    
        );
    }
}
