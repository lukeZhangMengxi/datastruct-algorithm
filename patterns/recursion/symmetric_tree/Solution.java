package patterns.recursion.symmetric_tree;

class Node {
    int val;
    Node left, right;
    Node(int v) {
        this.val = v;
    }
}

public class Solution {

    private boolean recursion(Node a, Node b) {
        
        if (a == null && b == null) return true;

        if (
            a == null && b != null ||
            a != null && b == null ||
            a.val != b.val
        ) {
            return false;
        }

        return recursion(a.left, b.right) && recursion(a.right, b.left);
    }

    public boolean isSymmetric(Node root) {
        if (root == null) return true;
        return recursion(root.left, root.right);
    }
}
