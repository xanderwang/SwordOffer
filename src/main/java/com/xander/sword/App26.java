package com.xander.sword;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class App26 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (null == pRootOfTree)
            return null;
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode right = Convert(pRootOfTree.right);
        if (null == left) {
            pRootOfTree.left = null;
            pRootOfTree.right = right;
            if (null != right) {
                right.left = pRootOfTree;
            }
            return pRootOfTree;
        }
        TreeNode leftEnd = left;
        while (leftEnd.right != null) {
            leftEnd = leftEnd.right;
        }
        leftEnd.right = pRootOfTree;
        pRootOfTree.left = leftEnd;
        pRootOfTree.right = right;
        if (null != right) {
            right.left = pRootOfTree;
        }
        return left;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
