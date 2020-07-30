package java_lang_interface.map.computeIfAbsent.random_pick_index;

import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    
    private Solution[] solutions;

    @Before
    public void init() {
        solutions = new Solution[] {
            new ConstructMapOfCollection()
        };
    }

    @Test
    public void simple() {
        int[] input = new int[] {1,2,3,3,3};
        Set<Integer> expectedIdices = new HashSet<>(Arrays.asList(2,3,4));
        for (Solution s : solutions) {
            s.init(input);

            int[] out = new int[30];
            for (int i=0; i<out.length; i++) { out[i] = s.pick(3); }

            boolean allTheSame = true;
            for (int v: out) { 
                assert(expectedIdices.contains(v));
                if (v != out[0]) { allTheSame = false; break; }
            }
            assertFalse(allTheSame);
        }
    }
}
