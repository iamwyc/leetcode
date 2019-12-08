package com.github.iamwyc.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author iamwyc
 * @date 2019/12/8
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 5
 * 输出:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class GeneratePascalTriangle2 {

  public static void main(String[] args) {
    List<Integer> generate = getRow(3);
    System.out.println(generate);
  }

  public static List<Integer> getRow(int rowIndex) {
    List<Integer> rowbefore = null;
    List<Integer> row = null;

    for (int i = 0; i <= rowIndex; i++) {
      row = new ArrayList<>();
      row.add(1);
      if (rowbefore != null) {
        for (int j = 0; j < rowbefore.size() - 1; j++) {
          Integer add = rowbefore.get(j) + rowbefore.get(j + 1);
          row.add(add);
        }
        row.add(1);
      }
      rowbefore = row;
    }
    return row;
  }

  /**
   * 最佳方法：
   *
   * 获取杨辉三角的指定行
   * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
   * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
   */
  public List<Integer> getRow2(int rowIndex) {
    List<Integer> res = new ArrayList<>(rowIndex + 1);
    long cur = 1;
    for (int i = 0; i <= rowIndex; i++) {
      res.add((int) cur);
      cur = cur * (rowIndex - i) / (i + 1);
    }
    return res;
  }

}
