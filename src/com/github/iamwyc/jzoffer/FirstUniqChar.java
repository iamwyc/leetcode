package com.github.iamwyc.jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iamwyc
 * @date 2020/2/18
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstUniqChar {

  public static void main(String[] args) {
    System.out.println(new FirstUniqChar());
  }

  public char firstUniqChar(String s) {
    Map<Character, Integer> cs = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char t = s.charAt(i);
      if (cs.containsKey(t)) {
        cs.put(t, cs.get(t) + 1);
      } else {
        cs.put(t, 1);
      }
    }

    for (int i = 0; i < s.length(); i++) {
      if (cs.get(s.charAt(i)) == 1) {
        return s.charAt(i);
      }
    }
    return ' ';
  }
}
