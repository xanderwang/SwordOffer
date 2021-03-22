package com.xander.sword;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * 输入 n 个整数，找出其中最小的 K 个数。
 * 
 * 例如输入 4,5,1,6,2,7,3,8 这 8 个数字，则最小的4个数字是 1,2,3,4 。
 * 
 */
public class App29 {

    int[] data;
    int curSize = 0;

    public App29(int k) {
        data = new int[k];
    }

    public static void main(String[] args) {
        App29 app29 = new App29(4);
        System.out.println(app29.GetLeastNumbers_Solution(new int[] { 4,5,1,6,2,7,3,8 }, 4));

    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        return GetLeastNumbers_Solution_3(input, k);
    }

    /**
     * 直接排序
     */
    public ArrayList<Integer> GetLeastNumbers_Solution_1(int[] input, int k) {
        if (null == input) {
            return null;
        }
        if (input.length <= k) {
            return arrayToList(input);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        return res;
    }

    /**
     * 大顶堆
     * 
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution_2(int[] input, int k) {
        if (null == input) {
            return null;
        }
        if (input.length <= k) {
            return arrayToList(input);
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        return res;
    }

    /**
     * 快排思想
     */
    public ArrayList<Integer> GetLeastNumbers_Solution_3(int[] input, int k) {
        if (null == input) {
            return null;
        }
        if (input.length <= k) {
            return arrayToList(input);
        }
        int l = 0, r = input.length - 1;
        int tmpIndex = k - 1;
        while (l < r) {
            if (l < tmpIndex) {
                // 找到比 tmp 大的
                if (input[l] > input[tmpIndex]) {
                    swap(input, l, tmpIndex);
                    tmpIndex = l;
                }
                l++;
                System.out.println("11  l:" + l + ",r:" + r + ",tmpIndex:" + tmpIndex);
            } else {
                // 找到比 tmp 小的
                if (input[r] < input[tmpIndex]) {
                    swap(input, r, tmpIndex);
                    tmpIndex = r;
                }
                System.out.println("21  l:" + l + ",r:" + r + ",tmpIndex:" + tmpIndex);
                r--;
            }
            System.out.println(Arrays.toString(input));
            if (l == r) {
                System.out.println("--- tmpIndex:" + tmpIndex);
                if (tmpIndex + 1 == k) {
                    // 找到了
                    break;
                } else {
                    // 没找到,改变范围
                    l = tmpIndex + 1 > k ? 0 : tmpIndex;
                    r = tmpIndex + 1 > k ? tmpIndex : input.length - 1;
                    tmpIndex = k - 1;
                }
                System.out.println("--- l:" + l + ",r:" + r + ",tmpIndex:" + tmpIndex);
            }
        }
        return arrayToList(input, k);
    }

    private void swap(int[] array, int m, int n) {
        array[m] = array[m] ^ array[n];
        array[n] = array[m] ^ array[n];
        array[m] = array[m] ^ array[n];
    }

    private ArrayList<Integer> arrayToList(int[] array) {
        return arrayToList(array, array.length);
    }

    private ArrayList<Integer> arrayToList(int[] array, int size) {
        if (size < 0 || size > array.length) {
            size = array.length;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            res.add(array[i]);
        }
        return res;
    }


        /**
     * 入堆，放到最后一个，然后调整
     */
    public void add(int e) {
        int next = curSize + 1;
        if (next >= data.length) {
            // 满了
            int max = data[0];
            if (max <= e) {
                // 说明不是最小的 k 个里面的
                return;
            }
            addToStart(e);
            return;
        }
        addToEnd(e);

    }

    /**
     * 从顶部添加，然后调整
     * 
     * @param e
     */
    private void addToStart(int e) {
        int eIndex = 0;
        data[eIndex] = e;
        // 开始调整
        while (eIndex < curSize) {
            int left = data[2 * eIndex];
            int right = data[2 * eIndex + 1];
            if (left < right) {
                swap(eIndex, 2 * eIndex + 1);
                eIndex = 2 * eIndex + 1;
            } else {
                swap(eIndex, 2 * eIndex);
                eIndex = 2 * eIndex;
            }
        }
    }

    /**
     * 从尾部添加，然后调整
     * 
     * @param e
     */
    private void addToEnd(int e) {
        int eIndex = curSize + 1;
        data[eIndex] = e;
        // 依次比较
        while (eIndex > 0) {
            int parentIndex = eIndex / 2;
            if (data[parentIndex] > e) {
                break;
            }
            swap(parentIndex, eIndex);
            eIndex = parentIndex;
        }
        curSize++;
    }

    private void swap(int m, int n) {
        int tmp = data[m];
        data[m] = data[n];
        data[n] = tmp;
    }
}
