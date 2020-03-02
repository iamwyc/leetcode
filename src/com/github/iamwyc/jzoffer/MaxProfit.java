package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/21
 */
public class MaxProfit {

  public static void main(String[] args) {
    System.out.println(new MaxProfit());
  }

  public int maxProfit2(int[] prices) {
    int max = 0;
    for (int i = 0; i < prices.length - 1; i++) {

      for (int j = i + 1; j < prices.length; j++) {
        max = Math.max(max, prices[j] - prices[i]);
      }
    }
    return max;
  }

  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int res = 0, min = prices[0];
    for (int i = 1; i < prices.length; i++) {
      res = Math.max(res, prices[i] - min);
      min = Math.min(prices[i], min);
    }
    return res;
  }
}
