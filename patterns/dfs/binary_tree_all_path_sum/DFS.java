package patterns.dfs.binary_tree_all_path_sum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFS extends Solution {

    private List<Integer> buf;

    @Override
    public List<List<Integer>> findPaths(TreeNode root, int sum) throws Exception {
        isValid(root, sum);

        buf = new LinkedList<>();
        List<List<Integer>> rst = new ArrayList<>();

        helper(root, sum, rst);

        return rst;
    }

    
    private void helper(TreeNode root, int curSum, List<List<Integer>> rst) {
        buf.add(root.val);

        if (root.left == null && root.right == null && curSum == root.val) {
            rst.add(new ArrayList<Integer>(buf));
        }

        if (root.left != null) helper(root.left, curSum-root.val, rst);
        if (root.right != null) helper(root.right, curSum-root.val, rst);

        buf.remove(buf.size()-1);
    }
    
}
