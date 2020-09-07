package java_lang_interface.regex.parse_paragraph_into_str_arr;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void simple() {
        Solution s = new MySolution();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] expected = new String[] {
            "bob", "hit", "a", "ball", "the", "hit", "ball", "flew", "far", "after",
            "it", "was", "hit"
        };
        String[] output = s.parseWordsIntoLowerCase(paragraph);

        assertEquals(expected.length, output.length);
        for (int i=0; i<expected.length; i++) {
            assert(output[i].equals(expected[i]));
        }
    }
}
