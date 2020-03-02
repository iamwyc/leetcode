package com.github.iamwyc.jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author iamwyc
 * @date 2020/2/22
 */
public class LengthOfLongestSubstring {

  public static void main(String[] args) {
    System.out.println(new LengthOfLongestSubstring());
  }

  public int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int strLen = s.length(), start = 0, res = 0, x;
    char c;
    for (int i = 0; i < strLen; ++i) {
      c = s.charAt(i);
      x = map.getOrDefault(c, -1);
      if (x >= start) {
        res = Math.max(res, i - start);
        start = x + 1;
      }
      map.put(c, i);
    }
    res = Math.max(res, strLen - start);
    return res;
  }
}
