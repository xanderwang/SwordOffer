package com.xander.sword;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * 解法，插入法，如果是奇数，跳过，如果是偶数，从当前数开始往后找到第一个奇数， 把找到的奇数插入到前面已经调整过的序列中
 */
public class App13 {

    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        // 1 2 3 4 5 6 7 8 9
        // 1 3 5 7 9 2 4 6 8
        System.out.println(Arrays.toString(data));
        reOrderArray(data);
        System.out.println(Arrays.toString(data));
    }

    public static void reOrderArray(int[] array) {
        int p = 0; // 当前的
        while (p < array.length) {
            // System.out.println("-------------------");
            // System.out.println(Arrays.toString(array));
            if ((array[p] & 1) == 0) { // 偶数
                for (int q = p + 1; q < array.length; q++) {
                    if ((array[q] & 1) == 1) { // p 后面第一个奇数
                        int tmp = array[q];
                        for (int c = q; c > p; c--) {
                            array[c] = array[c - 1];
                        }
                        array[p] = tmp;
                        // System.out.println(Arrays.toString(array));
                        break;
                    }
                }
            }
            p++;
        }
    }
}