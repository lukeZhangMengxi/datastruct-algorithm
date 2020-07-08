package patterns.fast_slow_pointers.linked_list_cycle_detect;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class MyTest {

    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            new FastSlowPointers()
        };
    }

    @Test
    public void simpleTestCase() throws Exception {

        ListNode cycleHead = new ListNode(0){{
            ListNode a = new ListNode(1);
            ListNode b = new ListNode(2);
            ListNode c = new ListNode(3);
            ListNode d = new ListNode(4);
            ListNode e = new ListNode(5);
            ListNode f = new ListNode(6);
            this.next = a;
            a.next = b;
            b.next = c;
            c.next = d;
            d.next = e;
            e.next = f;
            f.next = c;
        }};

        ListNode linearHead = new ListNode(0){{
            ListNode a = new ListNode(2);
            ListNode b = new ListNode(4);
            ListNode c = new ListNode(6);
            ListNode d = new ListNode(8);
            ListNode e = new ListNode(10);
            this.next = a;
            a.next = b;
            b.next = c;
            c.next = d;
            d.next = e;
        }};

        for (Solution method : methods) {
            assertTrue(method.hasCycle(cycleHead));
            assertFalse(method.hasCycle(linearHead));
        }

    }
}
