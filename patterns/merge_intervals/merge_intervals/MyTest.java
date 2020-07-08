package patterns.merge_intervals.merge_intervals;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            new MergeIntervls()
        };
    }

    @Test
    public void simpleTestCase() throws Exception {

        List<Interval> input = new ArrayList<Interval>() {
            private static final long serialVersionUID = 1L;
            {
                this.add(new Interval(1, 4));
                this.add(new Interval(2, 5));
                this.add(new Interval(7, 9));
            }
        };

        List<Interval> expected = new ArrayList<Interval>() {
            private static final long serialVersionUID = 1L;
            {
                this.add(new Interval(1, 5));
                this.add(new Interval(7, 9));
            }
        };

        for (Solution method: methods) {
            List<Interval> output = method.merge(input);
            assertEquals(expected.size(), output.size());
            for (int i=0; i<output.size(); i++) {
                assertEquals(expected.get(i).start, output.get(i).start);
                assertEquals(expected.get(i).end, output.get(i).end);
            }
        }

    }
}
