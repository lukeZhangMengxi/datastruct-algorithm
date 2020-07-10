package patterns.bfs.binary_tree_bfs;

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
            new BFS()
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

        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(2, 3),
            Arrays.asList(4, 5, 6, 7)
        );
        
        for (Solution method: methods) {
            List<List<Integer>> out = method.traverse(testRoot);
            assertEquals(expected.size(), out.size());
            for (int i=0; i<expected.size(); i++) {
                assertEquals(expected.get(i), out.get(i));
                for (int j=0; j<expected.get(i).size(); j++) {
                    assertEquals(expected.get(i).get(j), out.get(i).get(j));
                }
            }
        }

    }
}
