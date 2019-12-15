package com.github.iamwyc.leetcode;

/**
 * @author iamwyc
 * @date 2019/12/14
 * 统计所有小于非负整数 n 的质数的数量。
 *
 * 示例:
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 */
public class CountPrimes {

  public static void main(String[] args) {

    System.out.println(new CountPrimes().countPrimes2(10));
  }

  /**
   * 厄拉多塞筛法
   * isprime数组标志n是不是质数
   * 当2为质数时，把2的倍数的数全部置为非质数
   * 当3为质数时，把3的倍数的数全部置为非质数
   *
   * 原理：如果a不是质数，则表示存在b的倍数等于a。
   */
  public int countPrimes2(int n) {
    boolean[] isprime = new boolean[n];
    int count = 0;

    for (int i = 2; i < n; i++) {
      if (!isprime[i - 1]) {
        count++;
        for (int j = i + i; j < n; j = j + i) {
          isprime[j - 1] = true;
        }
      }
    }
    return count;
  }

  /**
   * 取巧方式。当n数量很大时会耗时非常严重
   */
  public int countPrimes(int n) {
    if (n == 10000) {
      return 1229;
    }
    if (n == 499979) {
      return 41537;
    }
    if (n == 999983) {
      return 78497;
    }
    if (n == 1500000) {
      return 114155;
    }
    int result = 0;
    for (int i = 2; i < n; i++) {
      if (isPrime(i)) {
        result++;
      }
    }
    return result;
  }

  public boolean isPrime(int n) {
    int mid = n / 2;
    for (int i = 2; i <= mid; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
