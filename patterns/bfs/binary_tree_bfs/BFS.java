package patterns.bfs.binary_tree_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS extends Solution {

    @Override
    public List<List<Integer>> traverse(TreeNode root) throws Exception {
        isValid(root);

        List<List<Integer>> rst = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>() {
            private static final long serialVersionUID = 1L;
            { this.add(root); }
        };
        while (q.size() > 0) {
            List<Integer> buf = new ArrayList<>();

            int levelSize = q.size();
            while (levelSize-- > 0) {
                TreeNode cur = q.poll();
                buf.add(cur.val);
                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            rst.add(buf);
        }

        return rst;
    }
    
}