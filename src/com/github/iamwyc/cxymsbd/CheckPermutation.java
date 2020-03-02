package com.github.iamwyc.cxymsbd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author iamwyc
 * @date 2020/3/2
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 *
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 */
public class CheckPermutation {

  public static void main(String[] args) {
    System.out.println(new CheckPermutation());
  }

  /**
   * 快
   */
  public boolean CheckPermutation2(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    char[] c1 = s1.toCharArray();
    char[] c2 = s2.toCharArray();
    Arrays.sort(c1);
    Arrays.sort(c2);
    for (int i = 0; i < c1.length; i++) {
      if (c1[i] != c2[i]) {
        return false;
      }
    }
    return true;
  }

  /**
   *慢
   */
  public boolean CheckPermutation(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return false;
    }
    Map<Character, Integer> cs = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      char c1 = s1.charAt(i);
      char c2 = s2.charAt(i);
      if (c1 != c2) {
        Integer v1 = cs.getOrDefault(c1, 0) + 1;
        Integer v2 = cs.getOrDefault(c2, 0) - 1;
        if (v1 == 0) {
          cs.remove(c1);
        } else {
          cs.put(c1, v1);
        }

        if (v2 == 0) {
          cs.remove(c2);
        } else {
          cs.put(c2, v2);
        }
      }
    }
    return cs.size() == 0;
  }
}
