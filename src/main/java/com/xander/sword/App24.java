package com.xander.sword;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 
 */
public class App24 {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> tmpPath = new ArrayList<>();

    public static void main(String[] args) {
        App24 app24 = new App24();
        TreeNode root = new TreeNode(2);
        System.out.println(app24.FindPath(root, 2));
    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        tmpPath.add(root.val);
        if (root.val == target) {
            // 找到了
            res.add(new ArrayList<Integer>(tmpPath));
        }
        FindPath(root.left, target - root.val);
        FindPath(root.right, target - root.val);
        tmpPath.remove(tmpPath.size() - 1);
        return res;
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
