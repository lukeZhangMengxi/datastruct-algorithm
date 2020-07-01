package structure.tree.binary_search_tree.validate;

import java.util.LinkedList;

public class ValidateBSTIteration {
    private class Context {
        TreeNode node;
        Integer lo, hi;
        Context(TreeNode n, Integer l, Integer h) {
            node = n;
            lo = l;
            hi = h;
        }
    }
    private LinkedList<Context> stack;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;

        stack = new LinkedList<Context>() {{ this.add(new Context(root, null, null)); }};
        while (!stack.isEmpty()) {
            Context ctx = stack.pollLast();
            if (ctx.node == null) continue;
            if (ctx.lo != null && ctx.node.val <= ctx.lo) return false;
            if (ctx.hi != null && ctx.node.val >= ctx.hi) return false;

            stack.addLast(new Context(ctx.node.left, ctx.lo, ctx.node.val));
            stack.addLast(new Context(ctx.node.right, ctx.node.val, ctx.hi));
        }

        return true;
    }

}