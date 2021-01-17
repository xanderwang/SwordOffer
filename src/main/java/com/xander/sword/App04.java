package com.xander.sword;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}， 则重建二叉树并返回。
 */
public class App04 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        App04 app04 = new App04();
        int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
        int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
        TreeNode tree = app04.reConstructBinaryTree(pre, in);
        Queue<TreeNode> dQueue = new LinkedList<>();
        TreeNode tmp = tree;
        dQueue.offer(tmp);
        while (!dQueue.isEmpty()) {
            tmp = dQueue.remove();
            System.out.println(tmp.val);
            if (null != tmp.left) {
                dQueue.offer(tmp.left);
            }
            if (null != tmp.right) {
                dQueue.offer(tmp.right);
            }
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (null == pre || 0 == pre.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        int[] newPre, newIn;
        int inRootIndex = 0;
        for (; inRootIndex < in.length; inRootIndex++) {
            if (in[inRootIndex] == pre[0]) {
                break;
            }
        }
        newPre = new int[inRootIndex];
        newIn = new int[inRootIndex];
        for (int i = 0; i < newPre.length; i++) {
            newPre[i] = pre[i + 1];
            newIn[i] = in[i];
        }
        TreeNode left = reConstructBinaryTree(newPre, newIn);
        newPre = new int[pre.length - 1 - inRootIndex];
        newIn = new int[pre.length - 1 - inRootIndex];
        for (int i = 0; i < newPre.length; i++) {
            newPre[i] = pre[inRootIndex + i + 1];
            newIn[i] = in[inRootIndex + i + 1];
        }
        TreeNode right = reConstructBinaryTree(newPre, newIn);
        root.left = left;
        root.right = right;
        return root;
    }

}