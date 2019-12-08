package com.github.iamwyc.leetcode;

/**
 * @author iamwyc
 * @date 2019/12/8
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class IsPalindrome {

  public static void main(String[] args) {

    System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    System.out.println(isPalindrome("race a car"));
  }

  public static boolean isPalindrome(String s) {
    int i = 0, j = s.length() - 1;
    while (i < j) {
      char c = s.charAt(i);
      if (!isValid(c)) {
        i++;
        continue;
      }
      char c1 = s.charAt(j);
      if (!isValid(c1)) {
        j--;
        continue;
      }
      if (toUp(c1) != toUp(c)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

  private static char toUp(char c) {
    if (c >= 'a' && c <= 'z') {
      return Character.toUpperCase(c);
    }
    return c;
  }

  private static boolean isValid(char c) {
    if (c >= '0' && c <= '9') {
      return true;
    }
    if (c >= 'a' && c <= 'z') {
      return true;
    }
    if (c >= 'A' && c <= 'Z') {
      return true;
    }
    return false;
  }
}
