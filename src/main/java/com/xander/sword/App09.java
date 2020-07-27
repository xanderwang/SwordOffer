package com.xander.sword;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class App09 {
  public static void main(String[] args) {
    System.out.println(JumpFloorII(20));
  }

  public static int JumpFloorII(int target) {
    // f(n) = f(n-1) + f(n-2) + f(1) + 1
    // f(n-1) = f(n-2) + f(1) + 1
    // f(n) - f(n-1) = f(n-1)
    // f(n) = 2 *f(n-1)
    int[] res = new int[target + 1];
    res[0] = 0;
    res[1] = 1;
    for (int i = 2; i <= target; i++) {
      res[i] = 2 * res[i - 1];
    }
    return res[target];
  }
}