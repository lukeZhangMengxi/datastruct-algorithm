package random_questions.redcue_arr_size_to_half;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void simple() {
        Solution s = new MySolution();
        assertEquals(5, s.minSetSize(new int[] {9,77,63,22,92,9,14,54,8,38,18,19,38,68,58,19}));
    }
}
