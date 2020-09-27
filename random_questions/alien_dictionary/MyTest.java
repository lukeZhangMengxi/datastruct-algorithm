package random_questions.alien_dictionary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyTest {
    @Test
    public void simple() {
        Solution s = new GraphNoIncomingEdgeNodes();

        assertEquals("wertf", s.alienOrder(
            new String[] {
                "wrt","wrf","er","ett","rftt"
            }
        ));
    }
}
