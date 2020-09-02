package java_lang_interface.map.LinkedHashMap.two_ordering_modes;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class MyTest {

    LinkedHashMap<String, Integer> insertMode;
    LinkedHashMap<String, Integer> accessMode;
    
    @Test
    public void testModes() {

        String[] keys = new String[] {"A", "B", "C", "D"};
        String accessKey = "B";
        String[] orderInsertMode = new String[] {"A", "B", "C", "D"};
        String[] orderAccessMode = new String[] {"A", "C", "D", "B"};

        insertMode = new LinkedHashMap<>(10, 0.75f, false);
        accessMode = new LinkedHashMap<>(10, 0.75f, true);

        // Operation
        for (String k: keys) {
            insertMode.put(k, 1);
            accessMode.put(k, 1);
        }
        insertMode.get(accessKey);
        accessMode.get(accessKey);


        List<String> bufInsertMode = new ArrayList<String>(insertMode.keySet());
        List<String> bufAccessMode = new ArrayList<String>(accessMode.keySet());
        assertArrayEquals(orderInsertMode, bufInsertMode.toArray());
        assertArrayEquals(orderAccessMode, bufAccessMode.toArray());
    }

    @Test
    @SuppressWarnings("serial")
    public void testRemoveEldestEntry() {

        String[] keys = new String[] {"A", "B", "C", "D"};
        String accessKey = "A";
        String[] orderInsertMode = new String[] {"B", "C", "D"};
        String[] orderAccessMode = new String[] {"C", "D", "A"};

        final int LIMIT = 3;

        insertMode = new LinkedHashMap<>(10, 0.75f, false) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return this.size() > LIMIT;
            }
        };

        accessMode = new LinkedHashMap<>(10, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return this.size() > LIMIT;
            }
        };

        // Operation
        for (String k: keys) {
            insertMode.put(k, 1);
            accessMode.put(k, 1);
            insertMode.get(accessKey);
            accessMode.get(accessKey);
        }

        List<String> bufInsertMode = new ArrayList<String>(insertMode.keySet());
        List<String> bufAccessMode = new ArrayList<String>(accessMode.keySet());
        assertArrayEquals(orderInsertMode, bufInsertMode.toArray());
        assertArrayEquals(orderAccessMode, bufAccessMode.toArray());
    }
}
