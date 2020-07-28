package test.linkedlist_kth_last;

class Node {
    int value;
    Node next;
    Node(int v) {
        this.value = v;
    }
}

interface Solution {
    void addNext(int v);
    int getKthLast(int k);    
}

class MySolution implements Solution {

    private Node idle;
    private Node tail;

    MySolution() {
        this.idle = new Node(-1);
        this.tail = this.idle;
    }

    @Override
    public void addNext(int v) {
        tail.next = new Node(v);
        tail = tail.next;
    }

    @Override
    public int getKthLast(int k) {
        if (k == 0) return 0;
        Node slow = idle.next;
        Node fast = idle;
        while (k-- > 0) {
            fast = fast.next;
            if (fast == null) return 0;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.value;
    }

}
