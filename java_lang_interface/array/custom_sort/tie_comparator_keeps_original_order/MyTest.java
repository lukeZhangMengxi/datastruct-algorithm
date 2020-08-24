package java_lang_interface.array.custom_sort.tie_comparator_keeps_original_order;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class MyTest {
    
    class Node {
        int originalOrder, sortedBy;
        Node(int a, int b) {
            originalOrder = a;
            sortedBy = b;
        }
    }

    @Test
    public void versionJDK() {
        assertEquals("11.0.7", System.getProperty("java.version"));
    }

    @Test
    public void tieComparatorKeepsOriginalOrder() {
        int constant = 100;
        Node[] target = new Node[] {
            new Node(0, constant), new Node(1, constant), new Node(2, constant),
            new Node(3, constant + 1), new Node(4, constant + 1)
        };

        Arrays.sort(target, (Node a, Node b) -> a.sortedBy - b.sortedBy);

        for (int i=0; i<target.length; i++) {
            assertEquals(i, target[i].originalOrder);
        }
    }
}
