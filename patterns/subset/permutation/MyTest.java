package patterns.subset.permutation;


import java.util.Arrays;
import java.util.Collections;
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

            Collections.sort(actual, (a, b) -> {
                for (int i=0; i<a.size(); i++) {
                    if (a.get(i) > b.get(i)) return a.get(i) - b.get(i);
                }
                return 0;
            });

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
            new DFS()
        };
    }

    @Test
    public void simpleTestCase() throws Exception {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                new int[] {1, 3, 5},
                Arrays.asList(
                    Arrays.asList(1, 3, 5),
                    Arrays.asList(1, 5, 3),
                    Arrays.asList(3, 1, 5),
                    Arrays.asList(3, 5, 1),
                    Arrays.asList(5, 1, 3),
                    Arrays.asList(5, 3, 1)
                )
            )
        };

        for (Solution m: methods) {
            for (TestCase t: cases) {
                assert(t.equalToExpected(m.findPermutations(t.input)));
            }
        }

    }

}
