package ru.nedorezova;

public class InvertTreeNode {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
