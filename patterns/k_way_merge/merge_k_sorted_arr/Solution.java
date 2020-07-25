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
