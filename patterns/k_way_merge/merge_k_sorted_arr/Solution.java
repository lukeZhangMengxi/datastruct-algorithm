package patterns.k_way_merge.merge_k_sorted_arr;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class ListNode {
    int value;
    ListNode next;
  
    ListNode(int value) {
        this.value = value;
    }
}

interface Solution {
    ListNode merge(ListNode[] lists);    
}

class UsePriorityQueue implements Solution {

    @Override
    public ListNode merge(ListNode[] lists) {

        PriorityQueue<ListNode> q = new PriorityQueue<>(
            lists.length,
            (a, b) -> a.value - b.value
        );

        ListNode idle = new ListNode(-1);
        ListNode cur = idle;
        
        Map<ListNode, Integer> getIndex = new HashMap<>(lists.length);
        for (int i=0; i<lists.length; i++) {
            if (lists[i] != null) {
                q.add(lists[i]);
                getIndex.put(lists[i], i);
                lists[i] = lists[i].next;

                while (q.size() >= lists.length) {
                    cur.next = q.poll();
                    cur = cur.next;
                    cur.next = null;

                    int idx = getIndex.get(cur);
                    if (lists[idx] != null) {
                        q.add(lists[idx]);
                        getIndex.put(lists[idx], idx);
                        lists[idx] = lists[idx].next;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            cur.next = q.poll();
            cur = cur.next;
            cur.next = null;
        }
        return idle.next;
    }

}

class DivideConquerMerge implements Solution {

    private ListNode m2(ListNode a, ListNode b) {
        ListNode idle = new ListNode(-1);
        ListNode cur = idle;

        while (a != null && b != null) {
            if (a.value < b.value) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }

        // Expecting exactly one or both of the two to be null
        if (a != null) cur.next = a;
        if (b != null) cur.next = b;

        return idle.next;
    }

    @Override
    public ListNode merge(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        int indexInterval = 1;
        while (indexInterval < lists.length) {
            for (int i=0; i+indexInterval<lists.length; i+=(indexInterval+1)) {
                lists[i] = m2(lists[i], lists[i+indexInterval]);
            }
            indexInterval *= 2;
        }
        
        return lists[0];
    }

}
