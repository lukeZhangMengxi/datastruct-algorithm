package java_lang_interface.array.custom_sort.List_toArray;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

@SuppressWarnings("serial")
public class MyTest {

    List<Integer> l = new LinkedList<>() {{
        this.add(1); this.add(2); this.add(3);
    }};

    @Test
    public void versionJDK() {
        assertEquals("11.0.7", System.getProperty("java.version"));
    }

    @Test
    public void primitiveTypeDoesNotWork() {
        Integer[] objects = new Integer[l.size()];
        Integer[] returned = l.toArray(objects);
        assertArrayEquals(new Integer[]{1,2,3}, objects);
        assertArrayEquals(new Integer[]{1,2,3}, returned);

        // Primitive type does NOT work with toArray(Object[])
        int[] primitiveValues = new int[l.size()];
        for (int i=0; i<l.size(); i++) {
            primitiveValues[i] = l.get(i);
        }
        assertArrayEquals(new int[]{1,2,3}, primitiveValues);
    }

    @Test
    public void smaeSizeArrayGivesSameArray() {
        Integer[] objects = new Integer[l.size()];
        Integer[] returned = l.toArray(objects);
        assertArrayEquals(new Integer[]{1,2,3}, objects);
        assertArrayEquals(new Integer[]{1,2,3}, returned);
        assert(objects == returned);
    }

    @Test
    public void largerArrayFilledWithNull() {
        Integer[] objects = new Integer[l.size()+2];
        Integer[] returned = l.toArray(objects);
        assertArrayEquals(new Integer[]{1,2,3,null,null}, objects);
        assertArrayEquals(new Integer[]{1,2,3,null,null}, returned);
        assert(objects == returned);
    }

    @Test
    public void smallerArrayGivesNewArray() {
        Integer[] objects = new Integer[l.size()-1];
        Integer[] returned = l.toArray(objects);
        assertArrayEquals(new Integer[]{null,null}, objects);
        assertArrayEquals(new Integer[]{1,2,3}, returned);
        assert(objects != returned);
    }
}
