package structure.one_d.linked_list.add_two_num;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

interface Solution {
    ListNode addTwoNumbers(ListNode l1, ListNode l2);    
}

class MS implements Solution {

    @Override
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        boolean add = false;
        ListNode idle = new ListNode(-1);
        ListNode cur = idle;

        while (l1 != null && l2 != null) {
            // Update value
            int v = l1.val + l2.val + (add ? 1 : 0);
            cur.next = new ListNode(v%10);

            // Next iteration
            add = v > 9;
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }

        // At most one of the two is not-null
        while (l1 != null) {
            // Update value
            int v = l1.val + (add ? 1 : 0);
            cur.next = new ListNode(v%10);

            // Next iteration
            add = v > 9;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            // Update value
            int v = l2.val + (add ? 1 : 0);
            cur.next = new ListNode(v%10);

            // Next iteration
            add = v > 9;
            l2 = l2.next;
            cur = cur.next;
        }

        if (add) cur.next = new ListNode(1);
        
        return idle.next;
    }

}
