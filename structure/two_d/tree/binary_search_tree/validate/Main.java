package structure.two_d.tree.binary_search_tree.validate;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        ValidateBSTIteration iteration = new ValidateBSTIteration();
        ValidateBSTRecursion recursion = new ValidateBSTRecursion();
        ValidateBSTInOrderRecursion inOrderRecursion = new ValidateBSTInOrderRecursion();
        ValidateBSTInOrderIteration inOrderIteration = new ValidateBSTInOrderIteration();

        if (iteration.isValidBST(root)) System.out.println("It is a BST");
        else System.out.println("It is not a BST");

        if (recursion.isValidBST(root)) System.out.println("It is a BST");
        else System.out.println("It is not a BST");

        if (inOrderRecursion.isValidBST(root)) System.out.println("It is a BST");
        else System.out.println("It is not a BST");

        if (inOrderIteration.isValidBST(root)) System.out.println("It is a BST");
        else System.out.println("It is not a BST");
    }
}
