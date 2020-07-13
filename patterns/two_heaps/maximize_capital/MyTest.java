package patterns.two_heaps.maximize_capital;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class MyTest {

    private Solution[] methods;

    private class TestCase {
        int[] capital;
        int[] profits;
        int initialCapital;
        int numLimit;
        int expectedMaxResult;

        public TestCase(int[] c, int[] p, int i, int n, int exp) {
            this.capital = c;
            this.profits = p;
            this.initialCapital = i;
            this.numLimit = n;
            this.expectedMaxResult = exp;
        }
    }

    @Before
    public void init() {
        methods = new Solution[] {
            new BruteForce(),
            new TwoHeaps()
        };
    }

    @Test
    public void simpleTestCase() throws Exception {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new int[] {0, 1, 2}, 
                new int[] {1, 2, 3},
                1, 2, 6
            ),
            new TestCase(
                new int[] {0, 1, 2, 3}, 
                new int[] {1, 2, 3, 5},
                0, 3, 8
            )
        };

        for (Solution m: methods) {
            for (TestCase t: cases) {
                assertEquals(
                    t.expectedMaxResult,
                    m.findMaximumCapital(t.capital, t.profits, t.numLimit, t.initialCapital)
                );
            }
        }
        

    }
}
