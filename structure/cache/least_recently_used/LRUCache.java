package structure.cache.least_recently_used;

import java.util.*;

public class LRUCache {
    private DoubleLinkedNode idleHead, idleTail;
    private class DoubleLinkedNode {
        int key, value;
        DoubleLinkedNode prev, next;
    }

    private void addNode(DoubleLinkedNode node) {
        node.prev = idleHead;
        node.next = idleHead.next;

        idleHead.next.prev = node;
        idleHead.next = node;
    }

    private void removeNode(DoubleLinkedNode node) {
        DoubleLinkedNode prev = node.prev;
        DoubleLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void moveToHead(DoubleLinkedNode node){
        removeNode(node);
        addNode(node);
    }

    private DoubleLinkedNode popTail() {
        DoubleLinkedNode res = idleTail.prev;
        removeNode(res);
        return res;
    }

    private Map<Integer, DoubleLinkedNode> cache;
    private int size, capacity;

    public LRUCache(int c) {
        size = 0;
        capacity = c;
        idleHead = new DoubleLinkedNode();
        idleTail = new DoubleLinkedNode();

        idleHead.next = idleTail;
        idleTail.prev = idleHead;

        cache = new HashMap<>();
    }

    public int get(int key) {
        DoubleLinkedNode node = cache.get(key);
        if (node == null) return -1;

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DoubleLinkedNode node = cache.get(key);

        if (node == null) {
            DoubleLinkedNode tmp = new DoubleLinkedNode();
            tmp.key = key;
            tmp.value = value;

            cache.put(key, tmp);
            addNode(tmp);
            size++;
            
            if (size > capacity) {
                DoubleLinkedNode tail = popTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}