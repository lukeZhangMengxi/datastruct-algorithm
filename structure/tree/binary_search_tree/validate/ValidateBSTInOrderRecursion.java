package structure.tree.binary_search_tree.validate;

import java.util.*;

public class ValidateBSTInOrderRecursion {
    private List<Integer> buf;

    private void init(TreeNode node) {
        if (node == null) return;

        init(node.left);
        buf.add(node.val);
        init(node.right);
    }
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        
        buf = new ArrayList<Integer>();
        init(root);

        for (int i=1; i<buf.size(); i++) {
            if (buf.get(i-1) >= buf.get(i)) return false;
        }

        return true;
    }
}