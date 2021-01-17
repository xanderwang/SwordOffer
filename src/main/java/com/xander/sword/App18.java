package com.xander.sword;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class App18 {

    public static void main(String[] args) {

    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Mirror(root.left);
        Mirror(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
