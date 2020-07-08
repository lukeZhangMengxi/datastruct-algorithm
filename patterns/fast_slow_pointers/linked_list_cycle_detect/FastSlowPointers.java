package patterns.fast_slow_pointers.linked_list_cycle_detect;

public class FastSlowPointers extends Solution {

    @Override
    public boolean hasCycle(ListNode head) throws Exception {
        isValid(head);

        ListNode fast=head, slow=head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }

        return false;
    }
    
}
