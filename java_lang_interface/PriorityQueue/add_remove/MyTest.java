package java_lang_interface.PriorityQueue.add_remove;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Test;

@SuppressWarnings("serial")
public class MyTest {
    @Test
    public void addRemoveFromHEAD() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) ->  b[0]*b[0] - a[0]*a[0] + b[1]*b[1] - a[1]*a[1]
        ) {{
            this.add(new int[] {2,2});
            this.add(new int[] {5,5});
            this.add(new int[] {2,5});
        }};

        int[][] expected = new int[][] { {5,5},{2,5},{2,2} };
        
        assertEquals(expected.length, pq.size());
        for (int i=0; i<expected.length; i++) {
            int[] cur = pq.remove();
            assertEquals(expected[i][0], cur[0]);
            assertEquals(expected[i][1], cur[1]);
        }
    }
}
