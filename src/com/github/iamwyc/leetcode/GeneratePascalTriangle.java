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
public class GeneratePascalTriangle {

  public static void main(String[] args) {
    List<List<Integer>> generate = generate(5);
    for (List<Integer> integers : generate) {
      System.out.println(integers);
    }
  }

  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>(numRows);
    List<Integer> rowbefore;
    List<Integer> row;

    for (int i = 0; i < numRows; i++) {
      row = new ArrayList<>();
      row.add(1);
      if ((i - 1) >= 0) {
        rowbefore = result.get(i - 1);
        for (int j = 0; j < rowbefore.size() - 1; j++) {
          Integer add = rowbefore.get(j) + rowbefore.get(j + 1);
          row.add(add);
        }
        row.add(1);
      }
      result.add(row);
    }
    return result;
  }
}
