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
        boolean rightToLeft = true;
        while (q.size() > 0) {
            List<Integer> buf = new LinkedList<>();

            int levelSize = q.size();
            while (levelSize-- > 0) {
                TreeNode cur = q.poll();
                if (rightToLeft) buf.add(0, cur.val);
                else buf.add(cur.val);

                if (cur.left != null) q.add(cur.left);
                if (cur.right != null) q.add(cur.right);
            }
            rst.add(buf);
            rightToLeft = !rightToLeft;
        }

        return rst;
    }
    
}