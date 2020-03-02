package com.github.iamwyc.hw;

import java.util.Scanner;

/**
 * @author iamwyc
 * @date 2020/2/6
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
 *
 * 最后一个数后面也要有空格
 *
 * 详细描述：
 *
 *
 * 函数接口说明：
 *
 * public String getResult(long ulDataInput)
 *
 * 输入参数：
 *
 * long ulDataInput：输入的正整数
 *
 * 返回值：
 *
 * String
 *
 *
 *
 * 输入描述:
 * 输入一个long型整数
 *
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 *
 * 示例1
 * 输入
 * 复制
 * 180
 * 输出
 * 复制
 * 2 2 3 3 5
 */
public class PrimeFactor {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      long n = s.nextLong();
      StringBuilder sb=new StringBuilder();
      while (n != 1) {
        for (int i = 2; i <= n; i++) {
          if (n % i == 0) {
            n /= i;
            sb.append(i);
            sb.append(" ");
            break;
          }
        }
      }
      System.out.println(sb.toString());
    }
  }
}
