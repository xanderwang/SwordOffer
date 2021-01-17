package com.xander.sword;

import java.util.Stack;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class App28 {

    public static void main(String[] args) {
        System.out.println(MoreThanHalfNum_Solution(new int[] { 1, 2, 3, 2, 4, 2, 5, 2, 3 }));
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        if (null == array || 0 == array.length) {
            return 0;
        }
        int count = 1, num = array[0];
        int rCount = 1, rNum = array[array.length - 1];
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                num = array[i];
                count++;
            } else {
                if (num == array[i]) {
                    count++;
                } else {
                    count--;
                }
            }
            if (rCount == 0) {
                rNum = array[array.length - 1 - i];
                rCount++;
            } else {
                if (rNum == array[array.length - 1 - i]) {
                    rCount++;
                } else {
                    rCount--;
                }
            }
        }
        if (count <= 0) {
            return 0;
        }
        if (num == rNum) {
            return num;
        }
        return 0;
    }
}
