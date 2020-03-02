package com.github.iamwyc.jzoffer;

/**
 * @author iamwyc
 * @date 2020/2/19
 *
 */
public class ReverseWords {

  public static void main(String[] args) {
    System.out.println(new ReverseWords().reverseWords("  hello world!  "));
  }

  public String reverseWords(String s) {
    String[] arr = s.split("\\s+");
    StringBuilder sb = new StringBuilder();
    for (int i = arr.length - 1; i >= 0; i--) {
      sb.append(arr[i]);
      if (i > 0) {
        sb.append(" ");
      }
    }
    return sb.toString().trim();
  }
}
