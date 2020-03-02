package com.github.iamwyc.hw;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author iamwyc
 * @date 2020/2/5
 */
public class LastWord {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    System.out.println(new LastWord().LastWord(str));
  }

  public int LastWord(String word) {
    int result = 0;
    for (int i = word.length() - 1; i >= 0; i--) {
      if (word.charAt(i) == ' ') {
        break;
      }
      result++;
    }
    return result;
  }
}
