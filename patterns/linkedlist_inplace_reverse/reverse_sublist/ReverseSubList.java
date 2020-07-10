package patterns.linkedlist_inplace_reverse.reverse_sublist;


public class ReverseSubList extends Solution {

    @Override
    public ListNode reverseSubList(ListNode head, int p, int q) throws Exception {
        isValid(head, p, q);

        // First segment
        ListNode firstSegTail = head;
        int count = 1;
        while (count < p-1) {
            firstSegTail = firstSegTail.next;
            count++;
        }

        // Second segment
        ListNode revSegHead;
        if (p > 1) revSegHead = firstSegTail.next;
        else revSegHead = head;
         
        ListNode revSegTail = revSegHead;
        count = p;
        while (count < q) {
            revSegTail = revSegTail.next;
            count++;
        }

        // Third segment
        ListNode thirdSegHead = revSegTail.next;

        // Reverse second segment
        revSegTail.next = null;
        ListNode reversedSegHead = reverse(revSegHead);

        // Re-link the second and the third
        ListNode reversedSegTail = reversedSegHead;
        while (reversedSegTail.next != null) reversedSegTail = reversedSegTail.next;
        reversedSegTail.next = thirdSegHead;

        // Re-link the first if exits
        if (p > 1) {
            firstSegTail.next = reversedSegHead;
            return head;
        } else {
            return reversedSegHead;
        }
    }

    private ListNode reverse(ListNode head) throws Exception {

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