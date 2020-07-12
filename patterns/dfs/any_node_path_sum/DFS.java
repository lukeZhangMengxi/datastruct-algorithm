package patterns.dfs.any_node_path_sum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFS extends Solution {

    private List<Integer> buf;

    @Override
    public List<List<Integer>> findPaths(TreeNode root, int sum) throws Exception {
        isValid(root, sum);

        List<List<Integer>> rst = new ArrayList<>();
        buf = new LinkedList<>();
        traverse(root, sum, rst);

        return rst;
    }

    private void traverse(TreeNode n, int sum, List<List<Integer>> rst) {
        if (n == null) return;

        findPathsFrom(n, sum, rst);

        traverse(n.left, sum, rst);
        traverse(n.right, sum, rst);
    }

    private void findPathsFrom(TreeNode n, int curSum, List<List<Integer>> rst) {
        if (n == null) return;

        buf.add(n.val);
        if (n.left == null && n.right == null && curSum == n.val) {
            rst.add(new ArrayList<>(buf));
        }

        findPathsFrom(n.left, curSum-n.val, rst);
        findPathsFrom(n.right, curSum-n.val, rst);

        buf.remove(buf.size()-1);
    }
    
}