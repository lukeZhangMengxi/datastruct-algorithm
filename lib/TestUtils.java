package lib;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

public class TestUtils {

    public static void assertListEquals(List<String> a, List<String> b) {
        assertEquals(a.size(), b.size());
        
        Collections.sort(a);
        Collections.sort(b);
        for (int i=0; i<a.size(); i++) {
            assertEquals(a.get(i), b.get(i));
        }
    }
    
}