package structure.two_d.tree.trie.camelcase_matching;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class MyTest {
    @Test
    public void simple() {
        Solution s = new UseTrie();

        String[] inputs = new String[] {
            "FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"
        };
        String pattern = "FB";
        boolean[] expected = new boolean[] {
            true,false,true,true,false
        };

        List<Boolean> out = s.camelMatch(inputs, pattern); 
        assertEquals(expected.length, out.size());
        for (int i=0; i<expected.length; i++) {
            assertEquals(expected[i], out.get(i));
        }
    }
}
