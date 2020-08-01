package structure.tree.trie.palindrome_pairs;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            new BruteForce()
        };
    }

    private void assertResult(List<List<Integer>> expected, List<List<Integer>> out) {
        
        assertEquals(expected.size(), out.size());
        
        Collections.sort(expected, (a, b) -> (a.get(0) != b.get(0)) ? a.get(0)-b.get(0) : a.get(1)-b.get(1));
        Collections.sort(out, (a, b) -> (a.get(0) != b.get(0)) ? a.get(0)-b.get(0) : a.get(1)-b.get(1));
        for (int i=0; i<expected.size(); i++) {
            assertEquals(expected.get(i).get(0), out.get(i).get(0));
            assertEquals(expected.get(i).get(1), out.get(i).get(1));
        }
    }

    @Test
    public void simple() {
        String[] words = new String[] {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(0,1), Arrays.asList(1,0), Arrays.asList(3,2), Arrays.asList(2,4)
        );

        for (Solution s: solutions) {
            assertResult(expected, s.palindromePairs(words));
        }
    }

    @Test
    public void fail1() {
        String[] words = new String[] {"a", ""};
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(0,1), Arrays.asList(1,0)
        );
        
        for (Solution s: solutions) {
            assertResult(expected, s.palindromePairs(words));
        }
    }

}
