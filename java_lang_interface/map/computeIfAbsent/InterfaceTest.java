package java_lang_interface.map.computeIfAbsent;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class InterfaceTest {
    
    @Test
    @SuppressWarnings("serial")
    public void computeOnExisting() {
        Map<String, List<Integer>> m = new HashMap<>() {{
            this.put("key", Arrays.asList(6,2,9));
        }};

        List<Integer> returnValue = m.compute("key", (k,v) -> new ArrayList<>() {{ this.add(v.get(0)); }} );

        assertEquals(1, returnValue.size());
        assertEquals(6, (int)returnValue.get(0));
        assertEquals(1, m.get("key").size());
        assertEquals(6, (int)m.get("key").get(0));
    }

    @Test(expected = NullPointerException.class)
    @SuppressWarnings("serial")
    public void computeOnAbsent() {
        Map<String, List<Integer>> m = new HashMap<>();

        m.compute("key", (k,v) -> new ArrayList<>() {{ this.add(v.get(0)); }} );

    }

    @Test
    @SuppressWarnings("serial")
    public void computeIfAbsentOnExisting() {
        Map<String, List<Integer>> m = new HashMap<>() {{
            this.put("key", Arrays.asList(6,2,9));
        }};

        List<Integer> returnValue = m.computeIfAbsent("key", k -> new ArrayList<>() {{ this.add(k.length()); }} );

        assertEquals(3, returnValue.size());
        assertEquals(6, (int)returnValue.get(0));
        assertEquals(3, m.get("key").size());
        assertEquals(6, (int)m.get("key").get(0));
    }

    @Test
    @SuppressWarnings("serial")
    public void computeIfAbsentOnAbsent() {
        Map<String, List<Integer>> m = new HashMap<>() {{
            this.put("key", Arrays.asList(6,2,9));
        }};

        List<Integer> returnValue = m.computeIfAbsent("another", k -> new ArrayList<>() {{ this.add(k.length()); }} );

        assertEquals(1, returnValue.size());
        assertEquals(7, (int)returnValue.get(0));
        assertEquals(1, m.get("another").size());
        assertEquals(7, (int)m.get("another").get(0));
    }

    @Test
    @SuppressWarnings("serial")
    public void computeIfPresentOnExisting() {
        Map<String, List<Integer>> m = new HashMap<>() {{
            this.put("key", Arrays.asList(6,2,9));
        }};

        List<Integer> returnValue = m.computeIfPresent("key", (k, v) -> new ArrayList<>() {{ this.add(k.length()); }} );

        assertEquals(1, returnValue.size());
        assertEquals(3, (int)returnValue.get(0));
        assertEquals(1, m.get("key").size());
        assertEquals(3, (int)m.get("key").get(0));
    }

    @Test
    @SuppressWarnings("serial")
    public void computeIfPresentOnAbsent() {
        Map<String, List<Integer>> m = new HashMap<>() {{
            this.put("key", Arrays.asList(6,2,9));
        }};

        List<Integer> returnValue = m.computeIfPresent("another", (k, v) -> new ArrayList<>() {{ this.add(k.length()); }} );

        assertEquals(null, returnValue);
        assertEquals(null, m.get("another"));
    }

}