package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/22
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成
 * “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TranslateNum {

  public static void main(String[] args) {
    System.out.println(new TranslateNum().translateNum(12258));
  }

  public int translateNum(int num) {
    String str = num + "";
    int n = str.length();
    int a = 1;
    int b = 1;
    int c = 1;
    for (int i = 2; i <= n; ++i) {
      if (str.charAt(i - 2) == '0' || Integer.parseInt(str.substring(i - 2, i)) > 25) {
        c = b;
      } else {
        c = a + b;
      }
      a = b;
      b = c;
    }
    return c;
  }

}
