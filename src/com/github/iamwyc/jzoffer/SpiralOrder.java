package com.github.iamwyc.jzoffer;

import java.util.Arrays;

/**
 * @author iamwyc
 * @date 2020/2/18
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SpiralOrder {

  public static void main(String[] args) {
    int[][] m = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int[][] m1 = {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12}
    };
    System.out.println(Arrays.toString(new SpiralOrder().spiralOrder(m)));
  }

  public int[] spiralOrder(int[][] matrix) {
    int row = matrix.length;
    if (row == 0) {
      return new int[0];
    }
    int c = matrix[0].length;
    int total = row * c, cur = 0;
    int[] ret = new int[total];
    int u = 0, d = row - 1, l = 0, r = c - 1;
    while (cur < total) {
      //右
      for (int i = l; i <= r; i++) {
        ret[cur++] = matrix[u][i];
      }
      u++;
      for (int i = u; i <= d; i++) {
        ret[cur++] = matrix[i][r];
      }
      r--;
      for (int i = r; i >= l && u <= d; i--) {
        ret[cur++] = matrix[d][i];
      }
      d--;
      for (int i = d; i >= u && l <= r; i--) {
        ret[cur++] = matrix[i][l];
      }
      l++;
    }
    return ret;
  }
}
