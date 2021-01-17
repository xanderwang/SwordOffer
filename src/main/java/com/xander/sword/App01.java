package com.xander.sword;

/**
 * 
 * 题目： 在一个二维数组中（每个一维数组的长度相同）， 每一行都按照从左到右递增的顺序排序， 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 
 * 分析： 暴力法，直接全部遍历，这个方法一定是可以的， 但是是不是最优的呢？ 显然不是，因为有额外的条件，比如同行，是递增的，同列，也是递增的。
 * 可以利用这个特性先确定列，然后从这个列开始依次找。
 */
public class App01 {
    public static void main(String[] args) {
        int target = 13;
        int[][] array = { 
            { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 
            { 11, 12, 13, 14, 15, 16, 17, 18, 19 },
            { 21, 22, 23, 24, 25, 26, 27, 28, 29 } 
        };
        System.out.println(Find(target, array));
    }

    public static boolean Find(int target, int[][] array) {
        // 先找到列，第一行如果存在比目标值小和目标值大的列，那么就是列的分界。
        int col = -1;
        for (int i = 0; i < array[0].length; i++) {
            if (array[0][i] == target) {
                return true;
            }
            if (array[0][i] > target) {
                col = i - 1;
                break;
            }
            col = i;
        }
        if (col < 0) {
            return false;
        }
        while (col-- > 0) {
            int row = array.length;
            while (--row >= 0) {
                if (array[row][col] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
