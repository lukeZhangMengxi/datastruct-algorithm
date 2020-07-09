package patterns.linkedlist_inplace_reverse.linkedlist_inplace_reverse;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            new Reverse()
        };
    }

    @Test
    public void simpleTestCase() throws Exception {

        ListNode inputHead = new ListNode(2) {{
            ListNode a = new ListNode(4);
            ListNode b = new ListNode(6);
            ListNode c = new ListNode(8);
            ListNode d = new ListNode(10);
            this.next = a;
            a.next = b;
            b.next = c;
            c.next = d;
        }};

        int[] expected = new int[] {10, 8, 6, 4, 2};

        for (Solution method: methods) {
            ListNode reversedHead = method.reverse(inputHead);
            for (int val: expected) {
                assertEquals(val, reversedHead.value);
                reversedHead = reversedHead.next;
            }
        }

    }
}
