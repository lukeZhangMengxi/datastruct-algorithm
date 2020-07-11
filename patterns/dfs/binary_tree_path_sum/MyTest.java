package patterns.dfs.binary_tree_path_sum;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class MyTest {

    private Solution[] methods;

    @Before
    public void init() {
        methods = new Solution[] {
            new DFS()
        };
    }

    @Test
    public void simpleTestCase() throws Exception {
        TreeNode testRoot = new TreeNode(1) {{
            TreeNode a = new TreeNode(2);
            TreeNode b = new TreeNode(3);
            TreeNode c = new TreeNode(4);
            TreeNode d = new TreeNode(5);
            TreeNode e = new TreeNode(6);
            TreeNode f = new TreeNode(7);
            this.left = a;
            this.right = b;
            a.left = c;
            a.right = d;
            b.left = e;
            b.right = f;
        }};

        int targetSum = 10;

        boolean expected = true;
        
        for (Solution method: methods) {
            assertEquals(expected, method.hasPath(testRoot, targetSum));
        }

    }
}
