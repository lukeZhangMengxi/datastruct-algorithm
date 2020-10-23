package patterns.recursion.symmetric_tree;

import org.junit.Test;

public class MyTest {

    Solution s = new Solution();

    @Test
    public void simple() {
        Node root = new Node(1) {{
            this.left = new Node(2) {{
                this.left = new Node(3);
                this.right = new Node(4);
            }};

            this.right = new Node(2) {{
                this.left = new Node(4);
                this.right = new Node(3);
            }};
        }};

        assert(s.isSymmetric(root));
    }
}
