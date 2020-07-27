package com.xander.sword;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class App10 {
  public static void main(String[] args) {
    System.out.println(RectCover(20));
  }

  public static int RectCover(int target) {
    // f(n) = f(n-1) + f(n-2)
    if (target <= 0) {
      return 0;
    }
    int[] res = { 0, 1, 2 };
    for (int i = res.length; i <= target; i++) {
      res[i % res.length] = res[(i - 1) % res.length] + res[(i - 2) % res.length];
    }
    return res[target % res.length];
  }
}