package com.github.iamwyc.hw;

import java.util.Scanner;

/**
 * @author iamwyc
 * @date 2020/2/6
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 *
 * 输出描述:
 * 输出到长度为8的新字符串数组
 *
 * 示例1
 * 输入
 * 复制
 * abc
 * 123456789
 * 输出
 * 复制
 * abc00000
 * 12345678
 * 90000000
 */
public class SameLengthString {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    String s1 = s.nextLine();
    String s2 = s.nextLine();

    deal(s1);
    deal(s2);

  }

  private static void deal(String s) {
    int length;
    while (s.length() > 0) {
      length = s.length();
      if (length < 8) {
        for (int i = 0; i < 8 - length; i++) {
          s = s + "0";
        }
        System.out.println(s);
        break;
      } else {
        System.out.println(s.substring(0, 8));
        s = s.substring(8);
      }
    }
  }
}
