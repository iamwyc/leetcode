package com.github.iamwyc.cxymsbd;

/**
 * @author iamwyc
 * @date 2020/3/2
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 * 输入：s1 = "waterbottle", s2 = "erbottlewat"
 * 输出：True
 * 示例2:
 *
 * 输入：s1 = "aa", "aba"
 * 输出：False
 * 提示：
 *
 * 字符串长度在[0, 100000]范围内。
 * 说明:
 *
 * 你能只调用一次检查子串的方法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipped-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsFlipedString {

  public static void main(String[] args) {
    System.out.println(new IsFlipedString());
  }

  public boolean isFlipedString(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    String ss = s2 + s2;
    return ss.contains(s1);
  }
}
