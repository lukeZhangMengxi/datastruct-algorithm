package patterns.subset.str_case_permutation;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class MyTest {

    private Solution[] methods;

    private class TestCase {
        String input;
        List<String> expected;

        public TestCase(String in, List<String> exp) {
            this.input = in;
            this.expected = exp;
            Collections.sort(this.expected, (a, b) -> a.compareTo(b));
        }

        public boolean equalToExpected(List<String> actual) {
            if (actual.size() != expected.size()) return false;

            Collections.sort(actual, (a, b) -> a.compareTo(b));

            for (int i=0; i<actual.size(); i++) {
                if (actual.size() != expected.size()) return false;

                if (actual.get(i).compareTo(expected.get(i)) != 0) return false;

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
                "ab",
                Arrays.asList("AB", "Ab", "aB", "ab")
            ),
            new TestCase(
                "ad52",
                Arrays.asList("ad52", "Ad52", "aD52", "AD52")
            ),
            new TestCase(
                "ab7c", 
                Arrays.asList("ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C")
            )
        };

        for (Solution m: methods) {
            for (TestCase t: cases) {
                assert(t.equalToExpected(m.findLetterCaseStringPermutations(t.input)));
            }
        }

    }

}
