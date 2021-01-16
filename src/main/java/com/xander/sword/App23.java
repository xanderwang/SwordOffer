package com.xander.sword;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 
 * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 */
public class App23 {

  public static void main(String[] args) {
    // int[] datas = { 4, 8, 6, 12, 16, 14, 10 };
    // int[] datas = { 5, 4, 3, 2, 1 };
    int[] datas = { 1, 2, 3, 4, 5 };
    System.out.println(VerifySquenceOfBST(datas));
  }

  /**
   * 判断是否是一个二叉树搜索树的后序
   * 
   * @param sequence
   * @return
   */
  public static boolean VerifySquenceOfBST(int[] sequence) {
    return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
  }

  /**
   * 判断某个范围是否是一个二叉搜索树的后序
   * 
   * @param sequence
   * @param start
   * @param end
   * @return
   */
  public static boolean VerifySquenceOfBST(int[] sequence, int start, int end) {
    System.out.println("\nsequence:" + Arrays.toString(sequence) + "start:" + start + ",end:" + end);
    if (start >= end) {
      // System.out.print(sequence[start]);
      // 为什么呢？说明只有根节点了，只一个根节点当然是 BST 了。
      return true;
    }
    int root = sequence[end];
    int leftChildEnd = Integer.MIN_VALUE;
    for (int i = start; i < end; i++) {
      // System.out.print(sequence[i]);
      // System.out.print(" ");
      if (leftChildEnd == Integer.MIN_VALUE) {
        // 找 left 的最后一个节点
        if (sequence[i] > root) {
          leftChildEnd = i - 1;
        }
      } else {
        // 验证右边的节点都大于 root
        if (sequence[i] < root) {
          return false;
        }
      }
    }
    if (leftChildEnd == Integer.MIN_VALUE) {
      leftChildEnd = end - 1;
      return VerifySquenceOfBST(sequence, start, leftChildEnd);
    }
    if (leftChildEnd == -1) {
      return VerifySquenceOfBST(sequence, leftChildEnd + 1, end - 1);
    }
    return VerifySquenceOfBST(sequence, start, leftChildEnd) && VerifySquenceOfBST(sequence, leftChildEnd + 1, end - 1);
  }
}
