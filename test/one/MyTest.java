package test.one;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void simpleTestCase() {
        Solution m = new SolutionImp();

        m.init(5, new int[] {1,2,3,4,5});

        assertEquals(m.queryMaxGrade(1, 5), 5);

        m.updateGrade(3, 6);

        assertEquals(m.queryMaxGrade(3, 4), 6);

        assertEquals(m.queryMaxGrade(4, 5), 5);

        m.updateGrade(4, 5);
        m.updateGrade(2, 9);

        assertEquals(m.queryMaxGrade(1, 5), 9);
    }

    @Test
    public void firstFailure() {
        Solution m = new SolutionImp();

        m.init(9, new int[] {28, 49, 11, 35, 40, 17, 57, 4, 6});

        assertEquals(m.queryMaxGrade(9, 9), 6);

        m.updateGrade(9, 79);

        assertEquals(m.queryMaxGrade(9, 5), 79);

        // assertEquals(m.queryMaxGrade(4, 5), 5);

        // m.updateGrade(4, 5);
        // m.updateGrade(2, 9);

        // assertEquals(m.queryMaxGrade(1, 5), 9);
    }
}
