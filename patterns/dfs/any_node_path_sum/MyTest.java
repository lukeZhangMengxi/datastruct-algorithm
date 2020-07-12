package patterns.dfs.any_node_path_sum;

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
            TreeNode a = new TreeNode(7);
            TreeNode b = new TreeNode(9);
            TreeNode c = new TreeNode(6);
            TreeNode d = new TreeNode(5);
            TreeNode e = new TreeNode(2);
            TreeNode f = new TreeNode(3);
            this.left = a;
            this.right = b;
            a.left = c;
            a.right = d;
            b.left = e;
            b.right = f;
        }};

        int targetSum = 12;

        int expectedLen = 3;
        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1, 9, 2),
            Arrays.asList(7, 5),
            Arrays.asList(9, 3)
        );
        
        for (Solution method: methods) {
            List<List<Integer>> out = method.findPaths(testRoot, targetSum);
            assertEquals(expectedLen, out.size());
            for (int i=0; i<out.size(); i++) {
                for (int j=0; j<out.get(i).size(); j++) {
                    assertEquals(expected.get(i).get(j), out.get(i).get(j));
                }
            }
        }

    }
}
