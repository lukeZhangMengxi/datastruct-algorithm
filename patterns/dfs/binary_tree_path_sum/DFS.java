package patterns.dfs.binary_tree_path_sum;

public class DFS extends Solution {

    @Override
    public boolean hasPath(TreeNode root, int sum) throws Exception {
        // isValid(root, sum);

        if (root == null) return false;

        if (sum == root.val && root.left == null && root.right == null ) return true;

        return hasPath(root.left, sum - root.val) || hasPath(root.right, sum - root.val);
    }
    
}