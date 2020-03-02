package com.github.iamwyc.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author iamwyc
 * @date 2020/2/7
 * 题目描述
 * 描述：
 *
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 *
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 *
 * 输入描述:
 * 输入一个int整数
 *
 * 输出描述:
 * 将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入
 * 复制
 * 1516000
 * 输出
 * 复制
 * 0006151
 */
public class ReverseDigit {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      int n = s.nextInt();
      int result=0;
      while(n>=3){
        int t = n%3;
        int m=n/3;
        result+=m;
        n=t+m;
      }
      if(n==2){
        result++;
      }
      System.out.println(result);
    }
  }


}
