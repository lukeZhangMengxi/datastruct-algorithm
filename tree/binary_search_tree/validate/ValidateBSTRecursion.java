package tree.binary_search_tree.validate;


public class ValidateBSTRecursion {

    private boolean isSubTreeBST(TreeNode node, TreeNode lo, TreeNode hi) {
        if (node == null)
            return true;

        if (lo != null && node.val <= lo.val)
            return false;
        if (hi != null && node.val >= hi.val)
            return false;

        if (!isSubTreeBST(node.left, lo, node))
            return false;
        if (!isSubTreeBST(node.right, node, hi))
            return false;

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return false;
        else
            return isSubTreeBST(root, null, null);
    }
}
