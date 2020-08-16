package structure.two_d.tree.trie.replace_word_with_root;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    
    private Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            // new BruteForce()
            new UseTrie()
        };
    }

    @Test
    public void simple() {
        List<String> roots = Arrays.asList("catt","bat","rat", "cat");
        String sentence = "the cattle was rattled by the battery";
        String expectedReplaced = "the cat was rat by the bat";
        for (Solution s: solutions) {
            assert(
                s.replaceWords(roots, sentence)
                .compareTo(expectedReplaced)
                == 0
            );
        }
    }

    @Test
    public void fail1() {
        List<String> roots = Arrays.asList("a", "aa", "aaa", "aaaa");
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        String expectedReplaced = "a a a a a a a a bbb baba a";
        for (Solution s: solutions) {
            assert(
                s.replaceWords(roots, sentence)
                .compareTo(expectedReplaced)
                == 0
            );
        }
    }
}
