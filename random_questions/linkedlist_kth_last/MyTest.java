package random_questions.linkedlist_kth_last;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void simple() {
        Solution s = new MySolution();

        for (int v: new int[] {1,2,3,4,5,6,7,8}) {
            s.addNext(v);
        }
        assertEquals(5, s.getKthLast(4));
    }

    @Test
    public void fail1() {
        Solution s = new MySolution();

        for (int v: new int[] {1,2,3,4,5,6,7,8}) {
            s.addNext(v);
        }
        assertEquals(0, s.getKthLast(9));
    }

    @Test
    public void fail2() {
        Solution s = new MySolution();

        for (int v: new int[] {1,2,3,4,5,6,7,8}) {
            s.addNext(v);
        }
        assertEquals(0, s.getKthLast(0));
    }
}
