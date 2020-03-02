package com.github.iamwyc.jzoffer;

import java.util.Arrays;

/**
 * @author iamwyc
 * @date 2020/2/19
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m]
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CuttingRope {

  public static void main(String[] args) {
    System.out.println(new CuttingRope().cuttingRope(120));
  }

  public int cuttingRope(int n) {
    int[] memory = new int[n + 1];
    memory[2] = 1;
    for (int i = 3; i <= n; i++) {
      for (int j = 1; j <= i - 1; j++) {
        int maxj = Math.max(memory[i - j], i - j) * j;
        memory[i] = Math.max(memory[i], maxj);
      }
    }
    return memory[n];
  }
}
