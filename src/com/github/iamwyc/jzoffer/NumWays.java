package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/17
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumWays {

  public static void main(String[] args) {
    System.out.println(new NumWays().numWays(7));
  }

  public int numWays(int n) {
    if (n <= 1) {
      return 1;
    }
    if (n == 2) {
      return 2;
    }
    long f0 = 1, f1 = 2;
    for (int i = 3; i <= n; i++) {
      long temp = f1;
      f1 = (f0 + f1) % 1000000007;
      f0 = temp;
    }
    return (int) f1;
  }
}
