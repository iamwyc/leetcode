package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/17
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"0123"及"-1E-16"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsNumber {

  public static void main(String[] args) {
    System.out.println(new IsNumber());
  }

  public boolean isNumber(String s) {
    String[] split = s.toUpperCase().split(".");
    if (split.length > 2) {
      return false;
    } else if (split.length == 2) {
      for (int i = 0; i < split[0].length(); i++) {

      }
    } else if (split.length == 1) {

    }
    return false;
  }
}
