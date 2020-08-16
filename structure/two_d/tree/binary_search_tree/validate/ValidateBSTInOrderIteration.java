package structure.two_d.tree.binary_search_tree.validate;

import java.util.*;

public class ValidateBSTInOrderIteration {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        Integer last = null;
        TreeNode cur = root;
        while (!stack.isEmpty() && root != null) {
            while (cur != null) { stack.addLast(cur); cur = cur.left; }

            cur = stack.pollLast();
            if (last != null && cur.val <= last) return false;

            if (cur.right != null) stack.addLast(cur.right);
            
            cur = cur.right;
        }

        return true;
    }
}