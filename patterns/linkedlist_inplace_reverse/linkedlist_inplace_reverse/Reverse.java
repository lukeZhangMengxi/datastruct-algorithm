package patterns.linkedlist_inplace_reverse.linkedlist_inplace_reverse;

public class Reverse extends Solution {

    @Override
    public ListNode reverse(ListNode head) throws Exception {
        isValid(head);

        if (head == null || head.next == null) return head;

        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }
    
        return previous;
    }
    
}