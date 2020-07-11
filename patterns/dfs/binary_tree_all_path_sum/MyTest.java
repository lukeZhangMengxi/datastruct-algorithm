package patterns.dfs.binary_tree_all_path_sum;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
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
            TreeNode c = new TreeNode(7);
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

        int expectedLen = 2;
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1, 2, 7),
            Arrays.asList(1, 3, 6)
        );
        
        for (Solution method: methods) {
            List<List<Integer>> out = method.findPaths(testRoot, targetSum);
            assertEquals(expectedLen, out.size());
            for (int i=0; i<out.size(); i++) {
                for (int j=0; j<3; j++) {
                    assertEquals(expected.get(i).get(j), out.get(i).get(j));
                }
            }
        }

    }
}
