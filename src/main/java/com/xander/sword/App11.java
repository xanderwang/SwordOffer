package com.xander.sword;

/**
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * 
 * 原码：绝对值的二进制
 * 
 * 反码：原码按位取反
 * 
 * 补码：反码 + 1
 * 
 */
public class App11 {

  public static void main(String[] args) {
    System.out.println(NumberOf1(1));
    System.out.println(NumberOf1(0));
    System.out.println(NumberOf1(-1));
  }

  public static int NumberOf1(int n) {
    // n & (n-1) 结果就是把 n 的最右边的一个 1 变成 0
    int count = 0;
    while (n != 0) {
      count++;
      n = n & (n - 1);
    }
    return count;
  }
}