package com.xander.sword;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class App17 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (null == root2) {
            return false;
        }
        if (root1 == null) {
            return false;
        }
        return isSameTree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        if (null == tree2) {
            return false;
        }
        if (tree1 == null) {
            return false;
        }
        return tree1.val == tree2.val && isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
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
