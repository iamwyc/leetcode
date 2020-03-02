package com.github.iamwyc.hw;

import java.util.Scanner;

/**
 * @author iamwyc
 * @date 2020/2/6
 * 题目描述
 * 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述:
 * 输出该数值的十进制字符串。
 *
 * 示例1
 * 输入
 * 复制
 * 0xA
 * 输出
 * 复制
 * 10
 */
public class HexToDec {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      String s1 = s.nextLine();
      double result = 0;
      int j = 0;
      for (int i = s1.length() - 1; i >= 0; i--) {
        char c = s1.charAt(i);
        int k = 0;
        if (c >= '0' && c <= '9') {
          k = c - '0';
        } else if (c >= 'A' && c <= 'F') {
          k = c - 'A' + 10;
        } else {
          break;
        }
        result = result + Math.pow(16, j) * k;
        j++;
      }
      long r = (long) result;
      System.out.println(r);
    }
  }
}
