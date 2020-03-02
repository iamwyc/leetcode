package com.github.iamwyc.hw;


public class Reverse {

  private static String reverse(String str) {
    String[] arr = str.split("\\s");
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      for (int j = arr[i].length() - 1; j >= 0; j--) {
        sb.append(arr[i].charAt(j));
      }
      sb.append(" ");
    }
    return sb.toString();
  }


}
