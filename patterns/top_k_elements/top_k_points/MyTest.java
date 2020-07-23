package patterns.top_k_elements.top_k_points;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    
    private Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {

        };
    }

    @Test
    public void testingTestFramework() {

        assert((new Point(1, 3)).equals(new Point(1, 3)));

        Set<Point> expected = new HashSet<>(Arrays.asList(new Point(1, 3)));
        assert(expected.contains(new Point(1, 3)));


        assert((new Point(1, 3)) != (new Point(1, 3)));

    }
}