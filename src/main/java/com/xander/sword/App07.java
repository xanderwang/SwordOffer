package com.xander.sword;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。 n<=39
 */
public class App07 {

  public static void main(String[] args) {
    System.out.println(Fibonacci(13));
  }

  public static int Fibonacci(int n) {
    if (n <= 0 || n > 39) {
      return 0;
    }
    int[] res = { 0, 1, 1 };
    for (int i = 3; i <= n; i++) {
      res[i % res.length] = res[(i - 1) % res.length] + res[(i - 2) % res.length];
    }
    return res[n % res.length];
  }

}