package patterns.subset.subset;


import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class MyTest {

    private Solution[] methods;

    private class TestCase {
        int[] input;
        List<List<Integer>> expected;

        public TestCase(int[] in, List<List<Integer>> exp) {
            this.input = in;
            this.expected = exp;
        }

        public boolean equalToExpected(List<List<Integer>> actual) {
            if (actual.size() != expected.size()) return false;

            for (int i=0; i<actual.size(); i++) {
                if (actual.get(i).size() != expected.get(i).size()) return false;

                for (int j=0; j<actual.get(i).size(); j++) {
                    if (actual.get(i).get(j) != expected.get(i).get(j)) return false;
                }
            }

            return true;
        }
    }

    @Before
    public void init() {
        methods = new Solution[] {
            new Subset()
        };
    }

    @Test
    public void simpleTestCase() throws Exception {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new int[] {1, 3},
                Arrays.asList(
                    Arrays.asList(),
                    Arrays.asList(1),
                    Arrays.asList(3),
                    Arrays.asList(1, 3)
                )
            ),
            new TestCase(
                new int[] {1, 5, 3},
                Arrays.asList(
                    Arrays.asList(),
                    Arrays.asList(1),
                    Arrays.asList(5),
                    Arrays.asList(1, 5),
                    Arrays.asList(3),
                    Arrays.asList(1, 3),
                    Arrays.asList(5, 3),
                    Arrays.asList(1, 5, 3)
                )
            )
        };

        for (Solution m: methods) {
            for (TestCase t: cases) {
                assert(t.equalToExpected(m.findSubsets(t.input)));
            }
        }
        

    }
}
