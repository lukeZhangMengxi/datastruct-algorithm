package structure.one_d.linked_list.add_two_num;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MyTest {

    private void assertNodeListEquals(ListNode expected, ListNode actual) {
        while (expected != null && actual != null) {
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }
        assertNull(expected);
        assertNull(actual);
    }

    @Test
    public void simple() {
        Solution s = new MS();

        assertNodeListEquals(
            new ListNode(7) {{ this.next = new ListNode(0) {{ this.next = new ListNode(8); }}; }}, 
            s.addTwoNumbers(
                new ListNode(2) {{ this.next = new ListNode(4) {{ this.next = new ListNode(3); }}; }},
                new ListNode(5) {{ this.next = new ListNode(6) {{ this.next = new ListNode(4); }}; }}
            )
        );

        assertNodeListEquals(
            new ListNode(0) {{ this.next = new ListNode(1); }}, 
            s.addTwoNumbers(
                new ListNode(4),
                new ListNode(6)
            )
        );

        assertNodeListEquals(
            new ListNode(0) {{ this.next = new ListNode(0) {{ this.next = new ListNode(1); }}; }}, 
            s.addTwoNumbers(
                new ListNode(1),
                new ListNode(9) {{ this.next = new ListNode(9); }}
            )
        );
    }
}
