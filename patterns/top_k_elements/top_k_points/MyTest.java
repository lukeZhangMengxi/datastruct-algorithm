package patterns.top_k_elements.top_k_points;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    
    private Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            new PriorityQ()
        };
    }

    @Test
    public void simple() {
        Point[] in = new Point[] {new Point(1, 3), new Point(3, 4), new Point(2, -1)};
        Set<Point> expected = new HashSet<>(Arrays.asList(new Point(1, 3), new Point(2, -1)));

        for (Solution s: solutions) {
            List<Point> out = s.findClosestPoints(in, 2);
            assertEquals(2, out.size());
            for (Point p: out)
                assert(expected.contains(p));
        }
    }

    @Test
    public void testingTestFramework() {

        assert((new Point(1, 3)).equals(new Point(1, 3)));

        Set<Point> expected = new HashSet<>(Arrays.asList(new Point(1, 3)));
        assert(expected.contains(new Point(1, 3)));


        assert((new Point(1, 3)) != (new Point(1, 3)));

    }

}