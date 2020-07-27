package com.xander.sword;

/**
 * 给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent。求 base 的 exponent 次方。
 * 
 * 保证 base 和 exponent 不同时为 0
 */
public class App12 {
  public static void main(String[] args) {
    System.out.println(Power(2, -2));
  }

  public static double Power(double base, int exponent) {
    // 暴力解法就是乘一遍
    // 优化方法就是利用已经有的 f(3) 和 f(1) 快速算出 f(7), f(7) = f(3) * f(3) * f(1)
    // f(n+1) = f(n/2) * f(n/2) * f(1)
    //        =  (f(n/4)*f(n/4)) * (f(n/4)*f(n/4)) * f(1)
    if (base == 0 && exponent == 0) {
      return 0;
    }
    if (exponent == 0) {
      return 1;
    }
    double res = 1, _base = base;
    int e = exponent;
    if (exponent < 0) {
      e = -exponent;
    }
    while (e > 0) {
      System.out.println(String.format("1-base:%s,e:%s,res:%s", _base, e, res));
      if (e % 2 > 0) {
        res *= _base;// ？？？
        System.out.println(String.format("2-base:%s,e:%s,res:%s", _base, e, res));
      }
      _base *= _base;
      e /= 2;
      System.out.println(String.format("3-base:%s,e:%s,res:%s", _base, e, res));
    }
    return exponent > 0 ? res : 1 / res;
  }
}