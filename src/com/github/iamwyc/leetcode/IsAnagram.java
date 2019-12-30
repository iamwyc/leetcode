package com.github.iamwyc.leetcode;

/**
 * @author iamwyc
 * @date 2019/12/15
 */
public class IsAnagram {

  public static void main(String[] args) {
    System.out.println(new IsAnagram().isAnagram("anagram", "nagaram"));
  }

  public boolean isAnagram(String s, String t) {
    int[] sCounts = new int[26];
    int[] tCounts = new int[26];
    for (char ch : s.toCharArray()) {
      sCounts[ch - 'a']++;
    }
    for (char ch : t.toCharArray()) {
      tCounts[ch - 'a']++;
    }
    for (int i = 0; i < 26; i++) {
      if (sCounts[i] != tCounts[i]) {
        return false;
      }
    }
    return true;
  }
}
