package com.github.iamwyc.hw;

/**
 * @author iamwyc
 * @date 2020/2/12
 * 有效括号
 * 给定一个至包括'(',')','[',']','{','}'的字符串，判断字符串是否有效
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合
 * 左括号必须以正确顺序闭合
 * 注意空字符串可以被认为有效字符串
 *
 * 示例1
 * 输入："()"
 * 输出：true
 *
 * 示例2
 * 输入："()"
 * 输出：true
 *
 * 示例3
 * 输入："([)]"
 * 输出：false
 */
public class EffectiveBrackets {
  public static void main(String[] args) {
    System.out.println(valid("()"));
    System.out.println(valid("()[]{}"));
    System.out.println(valid("([)]"));
    System.out.println(valid("( )"));
  }
  private static boolean valid(String line) {
    String sc = line.trim().replaceAll(" ", "");
    int length = sc.length();
    while (length > 0) {
      sc = sc.replaceAll("\\(\\)", "");
      sc = sc.replaceAll("\\{\\}", "");
      sc = sc.replaceAll("\\[\\]", "");
      if (sc.length() == length) {
        break;
      }
      length = sc.length();
    }
    return sc.length() == 0;
  }
}
