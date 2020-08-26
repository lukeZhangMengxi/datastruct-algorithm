package lib;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

public class TestUtils {

    public static void assertStringListEquals(List<String> a, List<String> b) {
        assertEquals(a.size(), b.size());
        
        Collections.sort(a);
        Collections.sort(b);
        for (int i=0; i<a.size(); i++) {
            assertEquals(a.get(i), b.get(i));
        }
    }

    public static <T> void assertListEquals(List<T> a, List<T> b) {
        assertEquals(a.size(), b.size());

        for (int i=0; i<a.size(); i++) {
            assertEquals(a.get(i), b.get(i));
        }
    }
    
}
