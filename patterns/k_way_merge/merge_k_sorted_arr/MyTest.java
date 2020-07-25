package patterns.k_way_merge.merge_k_sorted_arr;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MyTest {
    
    Solution[] solutions;

    @Before
    public void intit() {
        solutions = new Solution[] {
            new UsePriorityQueue()
        };
    }

    @Test
    public void simple() {
        ListNode[] in = new ListNode[] {
            new ListNode(2) {{ this.next = new ListNode(6) {{ this.next = new ListNode(8); }}; }},
            new ListNode(3) {{ this.next = new ListNode(6) {{ this.next = new ListNode(7); }}; }},
            new ListNode(1) {{ this.next = new ListNode(3) {{ this.next = new ListNode(4); }}; }}
        };
        ListNode expected = new ListNode(1) {{
            this.next = new ListNode(2) {{
                this.next = new ListNode(3) {{
                    this.next = new ListNode(3) {{
                        this.next = new ListNode(4) {{
                            this.next = new ListNode(6) {{
                                this.next = new ListNode(6) {{
                                    this.next = new ListNode(7) {{
                                        this.next = new ListNode(8);
                                    }};
                                }};
                            }};
                        }};
                    }};
                }};
            }};
        }};

        for (Solution s: solutions) {
            ListNode out = s.merge(in);
            while (out != null) {
                assertEquals(out.value, expected.value);
                out = out.next;
                expected = expected.next;
            }
        }
    }

}
