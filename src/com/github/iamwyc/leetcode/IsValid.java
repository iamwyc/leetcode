package com.github.iamwyc.leetcode;

/**
 * @author iamwyc
 * @date 2019/12/7
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 */
public class IsValid {


  public static void main(String[] args) {

    System.out.println(isValid2("(()])}[}[}[]][}}[}{})][[(]({])])}}(])){)((){"));
  }

  public static boolean isValid2(String s) {
    if (s == null || s.length() % 2 != 0) {
      return false;
    }
    if ("".equals(s)) {
      return true;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      int sbLen = sb.length();
      int sbIndex = sbLen - 1;
      if (c == ')') {
        if (sbIndex < 0) {
          return false;
        }
        char c1 = sb.charAt(sbIndex);
        if (c1 == '(') {
          sb.delete(sbIndex, sbLen);
        }
      } else if (c == '}') {
        if (sbIndex < 0) {
          return false;
        }
        char c1 = sb.charAt(sbIndex);
        if (c1 == '{') {
          sb.delete(sbIndex, sbLen);
        }
      } else if (c == ']') {
        if (sbIndex < 0) {
          return false;
        }
        char c1 = sb.charAt(sbIndex);
        if (c1 == '[') {
          sb.delete(sbIndex, sbLen);
        }
      } else {
        sb.append(c);
      }
    }
    return sb.length() == 0;
  }

  public static boolean isValid(String s) {

    if (s == null || s.length() % 2 != 0) {
      return false;
    }
    if ("".equals(s)) {
      return true;
    }
    int length = s.length();
    while (true) {
      s = s.replaceAll("\\(\\)", "");
      s = s.replaceAll("\\{\\}", "");
      s = s.replaceAll("\\[\\]", "");
      if (s.length() == length) {
        break;
      }
      length = s.length();
    }
    return "".equals(s);
  }
}
