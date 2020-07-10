package patterns.linkedlist_inplace_reverse.reverse_sublist;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class MyTest {

    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            new ReverseSubList()
        };
    }

    private class TestCase {
        ListNode head;
        int p, q;
        int[] expected;

        TestCase(ListNode head, int p, int q, int[] expected) {
            this.head = head;
            this.p = p;
            this.q = q;
            this.expected = expected;
        }
    }

    @Test
    public void simpleTestCase() throws Exception {

        TestCase[] testCases = new TestCase[3];

        testCases[0] = new TestCase(new ListNode(1) {{
            ListNode a = new ListNode(2);
            ListNode b = new ListNode(3);
            ListNode c = new ListNode(4);
            ListNode d = new ListNode(5);
            this.next = a;
            a.next = b;
            b.next = c;
            c.next = d;
        }}, 2, 4, new int[] {1, 4, 3, 2, 5});

        testCases[1] = new TestCase(new ListNode(1) {{
            ListNode a = new ListNode(2);
            ListNode b = new ListNode(3);
            ListNode c = new ListNode(4);
            ListNode d = new ListNode(5);
            this.next = a;
            a.next = b;
            b.next = c;
            c.next = d;
        }}, 1, 3, new int[] {3, 2, 1, 4, 5});

        testCases[2] = new TestCase(new ListNode(1) {{
            ListNode a = new ListNode(2);
            ListNode b = new ListNode(3);
            ListNode c = new ListNode(4);
            ListNode d = new ListNode(5);
            this.next = a;
            a.next = b;
            b.next = c;
            c.next = d;
        }}, 1, 5, new int[] {5, 4, 3, 2, 1});

        for (Solution method: methods) {
            for (TestCase t: testCases) {
                ListNode reversedHead = method.reverseSubList(t.head, t.p, t.q);
                for (int val: t.expected) {
                    assertEquals(val, reversedHead.value);
                    reversedHead = reversedHead.next;
                }
            }
        }

    }
}
