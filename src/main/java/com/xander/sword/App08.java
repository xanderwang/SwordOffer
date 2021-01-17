package com.xander.sword;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class App08 {
    public static void main(String[] args) {
        System.out.println(JumpFloor(13));
    }

    public static int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        // f(n) = f(n-1) + f(n-1)
        // f(1) = 1;
        // f(2) = 2;
        int[] res = { 0, 1, 2 };
        for (int i = 3; i <= target; i++) {
            res[i % res.length] = res[(i - 1) % res.length] + res[(i - 2) % res.length];
        }
        return res[target % res.length];
    }
}