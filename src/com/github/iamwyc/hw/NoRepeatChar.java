package com.github.iamwyc.hw;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author iamwyc
 * @date 2020/2/7
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
 *
 * 输入描述:
 * 输入N个字符，字符在ACSII码范围内。
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 *
 * 示例1
 * 输入
 * 复制
 * abc
 * 输出
 * 复制
 * 3
 */
public class NoRepeatChar {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      String st = s.nextLine();
      int result = 0;
      Set<Character> set = new HashSet<>();
      for (int i = 0; i < st.length(); i++) {
        char c = st.charAt(i);
        if (!set.contains(c)) {
          result++;
        }
        set.add(c);
      }
      System.out.println(result);
    }
  }
}
