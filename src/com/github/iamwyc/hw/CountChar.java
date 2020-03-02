package com.github.iamwyc.hw;

import java.util.Scanner;

/**
 * @author iamwyc
 * @date 2020/2/5
 *
 * 题目描述
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。
 *
 * 输入描述:
 * 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 *
 * 输出描述:
 * 输出输入字符串中含有该字符的个数。
 *
 * 示例1
 * 输入
 * 复制
 * ABCDEF
 * A
 * 输出
 * 复制
 * 1
 */
public class CountChar {

  public static void main(String[] args){
    Scanner s=new Scanner(System.in);
    String str=s.nextLine();
    char c=Character.toUpperCase(s.nextLine().charAt(0));
    int result=0;
    for(int i=0;i<str.length();i++){
      if(Character.toUpperCase(str.charAt(i))==c){
        result++;
      }
    }
    System.out.println(result);
  }
}
