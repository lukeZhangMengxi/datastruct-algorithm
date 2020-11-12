package patterns.linked_hashmap.lru;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    class Node {
        int key, val;
        Node prev, next;
        
        Node(int k, int v) {
            key = k;
            val = v;
        }
    }
    
    Map<Integer, Node> map;
    
    Node idle, tail;
    
    int c;

    public Solution(int capacity) {
        map = new HashMap<>(capacity+1);
        idle = new Node(-1, -1);
        tail = idle;
        c = capacity;
    }

    public void moveNodeToTail(Node node) {
        if (node == tail) return;

        if (node.prev != null) {
            // Modify prev and next node, if node is in the chain
            Node p = node.prev, n = node.next;
            p.next = n;
            if (n != null) n.prev = p;
        }

        tail.next = node;
        node.prev = tail;

        tail = node;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        
        Node newest = map.get(key);
        moveNodeToTail(newest);
        
        return newest.val;
    }
    
    public void put(int key, int value) {
        Node target;
        if (map.containsKey(key)) {
            target = map.get(key);
            target.val = value;
        } else {
            target = new Node(key, value);
            map.put(key, target);
        }

        moveNodeToTail(target);

        // Resize
        if (map.size() > c) {
            Node toRemove = idle.next;
            if (toRemove != null) {
                Node n = toRemove.next;
                idle.next = n;
                if (n != null) n.prev = idle;

                map.remove(toRemove.key);
            }
        }
         
    }

}
