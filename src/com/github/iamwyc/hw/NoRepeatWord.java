package com.github.iamwyc.hw;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author iamwyc
 * @date 2020/2/7
 * 输入一个字符串，求出该字符串包含的字符集合
 *
 * 输入描述:
 * 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。
 *
 * 输出描述:
 * 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。
 *
 * 输入例子1:
 * abcqweracb
 *
 * 输出例子1:
 * abcqwer
 */
public class NoRepeatWord {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      String line=s.nextLine();
      Set<Character> set=new HashSet<>();
      StringBuffer sb=new StringBuffer();
      for(int i=0;i<line.length();i++){
        char c=line.charAt(i);
        if(!set.contains(c)){
          sb.append(c);
        }
        set.add(c);
      }
      System.out.println(sb.toString());
    }
  }
}
