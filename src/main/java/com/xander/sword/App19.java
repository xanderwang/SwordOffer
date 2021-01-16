package com.xander.sword;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 
 */
public class App19 {

  public static void main(String[] args) {

  }

  public ArrayList<Integer> printMatrix(int[][] matrix) {
    ArrayList<Integer> result = new ArrayList<>();
    int rows = matrix.length, cols = matrix[0].length;
    for (int r = 0; r < rows; r++) {
      int left = r, top = r, right = cols - r - 1, bottom = rows - r - 1;
      if (left > right || top > bottom) {
        break;
      }
      // top
      for (int i = left; i <= right; i++) {
        result.add(matrix[top][i]);
      }
      // right
      for (int i = top + 1; i < bottom; i++) {
        result.add(matrix[i][right]);
      }
      // bottom
      for (int i = right; i >= left && top < bottom; i--) {
        result.add(matrix[bottom][i]);
      }
      // left
      for (int i = bottom - 1; i > top && left < right; i--) {
        result.add(matrix[i][left]);
      }
    }
    return result;
  }
}
