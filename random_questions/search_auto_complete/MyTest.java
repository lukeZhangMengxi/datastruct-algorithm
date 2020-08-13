package random_questions.search_auto_complete;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import lib.TestUtils;

public class MyTest {

    @Test
    public void simple() {
        Solution s = new BruteForce();

        s.init(
            new String[] {"i love you", "island", "ironman", "i love leetcode"},
            new int[] {5,3,2,2}
        );

        List<String> a = s.input('i');
        TestUtils.assertListEquals(
            Arrays.asList("i love you", "island", "i love leetcode"), 
            a
        );

        TestUtils.assertListEquals(
            Arrays.asList("i love you", "i love leetcode"), 
            s.input(' ')
        );

        TestUtils.assertListEquals(
            Arrays.asList(), 
            s.input('a')
        );

        TestUtils.assertListEquals(
            Arrays.asList(), 
            s.input('#')
        );

        TestUtils.assertListEquals(
            Arrays.asList("i love you", "island", "i love leetcode"), 
            s.input('i')
        );

        TestUtils.assertListEquals(
            Arrays.asList("i love you", "i love leetcode", "i a"), 
            s.input(' ')
        );

        TestUtils.assertListEquals(
            Arrays.asList("i a"), 
            s.input('a')
        );

        TestUtils.assertListEquals(
            Arrays.asList(), 
            s.input('#')
        );
    }
}
