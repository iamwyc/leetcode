package com.github.iamwyc.hw;

import java.util.Scanner;

public class Template {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    while (s.hasNext()) {
      String line = s.nextLine();
      StringBuffer r = new StringBuffer();
      String[] arr = line.split(" ");
      int count = 1;
      for (int i = 1; i < arr.length; i++) {
        if ("A".equals(arr[i])) {
          r.append("12 34");
          count += 2;
        } else if ("B".equals(arr[i])) {
          r.append("AB CD");
          count += 2;
        } else {
          r.append(arr[i]);
          count += 1;
        }
        r.append(" ");
      }
      System.out.println(Integer.toHexString(count).toUpperCase() + " " + r.toString().toUpperCase());
    }
  }
}
