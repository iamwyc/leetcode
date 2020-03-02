package com.github.iamwyc.cxymsbd;

/**
 * @author iamwyc
 * @date 2020/3/2
 *
 * 面试题 01.07. 旋转矩阵
 * 给定一幅由N × N矩阵表示的图像，其中每个像素的大小为4字节，编写一种方法，将图像旋转90度。
 *
 * 不占用额外内存空间能否做到？
 *
 *
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 *
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class Rotate {

  public static void main(String[] args) {
    System.out.println(new Rotate());
  }

  public void rotate(int[][] matrix) {
    int len = matrix.length;
    //左右翻
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][len - 1 - j];
        matrix[i][len - 1 - j] = temp;
      }
    }
    //对角线翻转
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len - i; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[len - 1 - j][len - 1 - i];
        matrix[len - 1 - j][len - 1 - i] = temp;
      }
    }
  }
}
