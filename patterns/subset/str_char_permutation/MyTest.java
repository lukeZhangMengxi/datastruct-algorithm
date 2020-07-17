package patterns.subset.str_char_permutation;


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
            new Recursion()
        };
    }

    @Test
    public void simpleTestCase() throws Exception {
        TestCase[] cases = new TestCase[] {
            new TestCase(
                "abc",
                Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba")
            )
        };

        for (Solution m: methods) {
            for (TestCase t: cases) {
                assert(t.equalToExpected(m.findStringPermutations(t.input)));
            }
        }

    }

}
